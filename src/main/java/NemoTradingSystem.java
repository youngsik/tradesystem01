public class NemoTradingSystem implements TradingSystem{
    public static final String LOGIN_FAIL_LOG = "님 로그인 실패";
    public static final String LOGIN_SUCCESS_LOG = "님 로그인 성공";
    public static final int TEADE_COUNT = 3;
    public static final int GET_PRICE_MINUTE = 1;
    public static final int NOT_BUY_TIMING = -1;

    private String id;
    private String pw;
    private NemoApi nemoApi;

    public NemoTradingSystem() {
        this.nemoApi = new NemoApi();
    }

    public NemoTradingSystem(NemoApi nemoApi) {
        this.nemoApi = nemoApi;
    }

    public String login(String id, String pw) {
        if (!isPossibleId(id) || !isPossiblePW(pw)) {
            return id + LOGIN_FAIL_LOG;
        }
        nemoApi.certification(id, pw);
        this.id = id;
        this.pw = pw;
        return this.id + LOGIN_SUCCESS_LOG;
    }

    private boolean isPossibleId(String id) {
        return id.equals("ABC");
    }

    private boolean isPossiblePW(String pw) {
        return pw.equals("BTS");
    }

    @Override
    public String buy(String stockCode, int count, int price) {
        try {
            nemoApi.purchasingStock(stockCode, price, count);
            return String.format("%s를 %d 가격에 매수하였음", stockCode,price);
        } catch (Exception e) {
            return String.format("%s 매수 중 오류 발생: %s", stockCode, e.getMessage());
        }
    }

    @Override
    public String sell(String stockCode, int count, int price) {
        nemoApi.sellingStock(stockCode, price, count);
        return stockCode + "를 " + price + " 가격에 매도하였음";
    }

    public int getPrice(String stockCode) {
        try {
            return nemoApi.getMarketPrice(stockCode, 1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int buyNiceTiming(String stockCode, int amount) throws InterruptedException {
        int resPrice = getBuyPrice(stockCode);

        if (resPrice == NOT_BUY_TIMING)
            return NOT_BUY_TIMING;

        buy(stockCode, (int) amount / resPrice, resPrice);
        return amount / resPrice;
    }

    private int getBuyPrice(String stockCode) throws InterruptedException {
        int resPrice = NOT_BUY_TIMING;
        for (int i = 0; i < TEADE_COUNT; i++) {
            int currentPrice = nemoApi.getMarketPrice(stockCode, GET_PRICE_MINUTE);
            if (currentPrice <= resPrice) {
                return NOT_BUY_TIMING;
            }
            resPrice = currentPrice;
        }
        return resPrice;
    }

    public void sellNiceTiming(String stockCode, int stockCount) {
        int[] priceTrend = new int[3];
        for(int i = 0; i < priceTrend.length; i++) {
            try {
                priceTrend[i] = nemoApi.getMarketPrice(stockCode, 1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if( priceTrend[0] < priceTrend[1] && priceTrend[1] < priceTrend[2]) {
            int sellingPrice = priceTrend[2];
            nemoApi.sellingStock(stockCode, sellingPrice, stockCount);
        } else {
            System.out.println("매도 타이밍이 좋지 않습니다.");
        }
    }

    public void sellNiceTiming(String stockCode, int stockCount) throws InterruptedException {
        int[] priceTrend = getPriceTrend(stockCode, 3);
        if (isDownTrend(priceTrend)) {
            int sellingPrice = priceTrend[2];
            nemoApi.sellingStock(stockCode, sellingPrice, stockCount);
        } else {
            System.out.println("매도 타이밍이 좋지 않습니다.");
        }
    }

    private int[] getPriceTrend(String stockCode, int count) throws InterruptedException {
        int[] prices = new int[count];
        for (int i = 0; i < count; i++) {
            prices[i] = nemoApi.getMarketPrice(stockCode, 1);
        }
        return prices;
    }

    private boolean isDownTrend(int[] prices) {
        if (prices.length < 3) return false;
        return prices[0]>  prices[1] && prices[1] > prices[2];
    }
}
