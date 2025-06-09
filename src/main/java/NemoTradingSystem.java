public class NemoTradingSystem implements TradingSystem{
    public static final String LOGIN_FAIL_LOG = "님 로그인 실패";
    public static final String LOGIN_SUCCESS_LOG = "님 로그인 성공";

    private String id;
    private String pw;
    private NemoApi nemoApi;

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
  
    public String sell(String stockCode, int count, int price) {
        return stockCode + "를 " + price + " 가격에 매도하였음";
    }


    public String buy(String stockCode, int count, int price) {
        try {
            nemoApi.purchasingStock(stockCode, price, count);
            return String.format("%s를 %d 가격에 매수하였음", stockCode,price);
        } catch (Exception e) {
            return String.format("%s 매수 중 오류 발생: %s", stockCode, e.getMessage());
        }
    }

    public int getPrice(String stockCode) {
        try {
            return nemoApi.getMarketPrice(stockCode, 1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
