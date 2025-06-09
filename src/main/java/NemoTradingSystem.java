public class NemoTradingSystem implements TradingSystem {
    NemoAPI nemoAPI;

    public NemoTradingSystem() {
        this.nemoAPI = new NemoAPI();
    }

    public NemoTradingSystem(NemoAPI nemoAPI) {
        this.nemoAPI = nemoAPI;
    }
  
    public String login(String id, String password) {

        // String result = nemoAPI.login(id, password);
        // if (result.equals(NemoAPI.NOT_FOUND)){
        //     nemoAPI.signUp(id, password);
        //     result = nemoAPI.login(id, password);
        // }

        // return result;

        return null;
    }
  
    public String sell(String stockCode, int count, int price) {
        return stockCode + "를 " + price + " 가격에 매도하였음";
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
