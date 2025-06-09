public class KiumTradingSystem {
    public static final String LOGIN_FAIL_LOG = "님 로그인 실패";
    public static final String LOGIN_SUCCESS_LOG = "님 로그인 성공";

    private String id;
    private String pw;
    private KiwerAPI kiwerAPI;

    public KiumTradingSystem() {
        this.kiwerAPI = new KiwerAPI();
    }

    public KiumTradingSystem(KiwerAPI kiwerAPI) {
        this.kiwerAPI = kiwerAPI;
    }

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

    public String buy(String stockCode, int count, int price) {
        kiwerAPI.buy(stockCode, count, price);
        return String.format("%s를 %d 가격에 매수하였음", stockCode, price);
    }

}
