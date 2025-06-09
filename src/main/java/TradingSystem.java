public interface TradingSystem {
    public String login(String id, String pw);
    public String buy(String stockCode, int count, int price);
    public String sell(String stockCode, int count, int price);
}
