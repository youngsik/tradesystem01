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
        return tradingSystem.buy(stockCode, count, price);
    }

    public String sell(String stockCode, int count, int price) {
        return tradingSystem.sell(stockCode, count, price);
    }
}