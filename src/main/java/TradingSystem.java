public interface TradingSystem {
    public String login(String id, String pw);
    public String buy(String stockCode, int count, int price);
    public int getPrice(String stockCode);
    public String sell(String stockCode, int count, int price);
    public int sellNiceTiming(String stockCode, int count) throws InterruptedException;
    public int buyNiceTiming(String stockCode, int price) throws InterruptedException;
}
