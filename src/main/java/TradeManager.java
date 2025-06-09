public class TradeManager {

    private TradingSystem tradingSystem;

    public TradeManager(TradingSystem tradingSystem) {
        this.tradingSystem = tradingSystem;
    }

    public String login(String id, String pw) {
        return tradingSystem.login(id, pw);
    }

}