public class KiumTradingSystem implements TradingSystem{
    public static final String LOGIN_FAIL_LOG = "님 로그인 실패";
    public static final String LOGIN_SUCCESS_LOG = "님 로그인 성공";
    public static final int TERND_COUNT = 3;

    private String id;
    private String pw;
    private KiwerAPI kiwerAPI;

    public KiumTradingSystem() {
        this.kiwerAPI = new KiwerAPI();
    }

    public KiumTradingSystem(KiwerAPI kiwerAPI) {
        this.kiwerAPI = kiwerAPI;
    }

    public int getPrice(String stockCode) {
        return kiwerAPI.currentPrice(stockCode);
    }

    @Override
    public String login(String id, String pw) {
        if (!isPossibleId(id) || !isPossiblePW(pw)) {
            return id + LOGIN_FAIL_LOG;
        }
        kiwerAPI.login(id, pw);
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
        kiwerAPI.buy(stockCode, count, price);
        return String.format("%s를 %d 가격에 매수하였음", stockCode, price);

    }
    @Override
    public String sell(String stockCode, int count, int price) {
        kiwerAPI.sell(stockCode, count, price);
        return stockCode + "를 " + price+" 가격에 매도하였음";
    }

    @Override
    public void sellNiceTiming(String stockCode, int count) {
        int price = kiwerAPI.currentPrice(stockCode);
        for(int i = 1; i< 3; i++){
            int nowPrice = kiwerAPI.currentPrice(stockCode);
            if(price > nowPrice) {
                price = nowPrice;
                continue;
            }
            throw new RuntimeException("내려가는 추세가 아닙니다. 매도 실패");
        }
        kiwerAPI.sell(stockCode, count, price);
    }

    public int buyNiceTiming(String stockCode, int amount) {
        int price = -1;
        for (int i = 0; i < TERND_COUNT; i++){
            int currentPrice = kiwerAPI.currentPrice(stockCode);
            if (currentPrice <= price) {
                return -1;
            }
            price = currentPrice;
        }

        return amount / price;
    }
}
