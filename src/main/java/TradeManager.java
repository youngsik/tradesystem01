public class TradeManager {

    private static TradeManager tradeManager;
    private TradingSystem tradingSystem;

    private TradeManager() {}

    public static TradeManager getInstance(){
        if(tradeManager == null)
            tradeManager = new TradeManager();
        return tradeManager;
    }

    public void selectStockBrocker(TradingSystem tradingSystem){
        this.tradingSystem = tradingSystem;
    }

    public String login(String id, String pw) {
        return tradingSystem.login(id, pw);
    }

    public String buy(String stockCode, int count, int price) {
        try {
            tradingSystem.buy(stockCode, price, count);
            return String.format("%s를 %d 가격에 매수하였음", stockCode,price);
        } catch (Exception e) {
            return String.format("%s 매수 중 오류 발생: %s", stockCode, e.getMessage());
        }
    }

}