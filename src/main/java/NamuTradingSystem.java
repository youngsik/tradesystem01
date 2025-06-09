public class NamuTradingSystem {
    NemoAPI nemoAPI;

    public NamuTradingSystem() {
        this.nemoAPI = new NemoAPI();
    }

    public String buy(String stockCode, int count, int price) {
        try {
            nemoAPI.purchasingStock(stockCode, price, count);
            return String.format("%s를 %d 가격에 매수하였음", stockCode,price);
        } catch (Exception e) {
            return String.format("%s 매수 중 오류 발생: %s", stockCode, e.getMessage());
        }
    }
}
