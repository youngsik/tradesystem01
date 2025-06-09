public class KiumTradingSystem {
    private KiwerAPI kiwerAPI;

    public KiumTradingSystem() {
        kiwerAPI = new KiwerAPI();
    }

    public String buy(String stockCode, int count, int price) {
        kiwerAPI.buy(stockCode, count, price);
        return stockCode + "를 " + price+" 가격에 매도하였음";
    }


}
