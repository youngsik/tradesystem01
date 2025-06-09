public class KiumTradingSystem {

    private KiwerAPI kiwerAPI;

    public KiumTradingSystem(KiwerAPI kiwerAPI) {
        this.kiwerAPI = kiwerAPI;
    }

    public String buy(String stockCode, int count, int price) {
        kiwerAPI.buy(stockCode, count, price);
        return String.format("%s를 %d 가격에 매수하였음", stockCode, price);
    }

}
