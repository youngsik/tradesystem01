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
            tradingSystem.buy(stockCode, count, price);
            return String.format("%s를 %d 가격에 매수하였음", stockCode,price);
        } catch (Exception e) {
            return String.format("%s 매수 중 오류 발생: %s", stockCode, e.getMessage());
        }
    }

    public String sell(String stockCode, int count, int price) {
        try {
            tradingSystem.sell(stockCode, count, price);
            return String.format("%s를 %d 가격에 매도하였음", stockCode,price);
        } catch (Exception e) {
            return String.format("%s 매도 중 오류 발생: %s", stockCode, e.getMessage());
        }
    }

    public int getPrice(String stockCode) {
        return tradingSystem.getPrice(stockCode);
    }
}