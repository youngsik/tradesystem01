public class NemoTradingSystem implements TradingSystem {
    NemoApi nemoApi;

    public NemoTradingSystem() {
        this.nemoApi = new NemoApi();
    }

    @Override
    public String login(String id, String password){

        String result = nemoApi.login(id, password);
        if (result.equals(NemoApi.NOT_FOUND)){
            nemoApi.signUp(id, password);
            result = nemoApi.login(id, password);

        }

        return result;
    }
  
    public String sell(String stockCode, int count, int price) {
        return stockCode + "를 " + price + " 가격에 매도하였음";
    }


    public String buy(String stockCode, int count, int price) {
        try {
            nemoApi.purchasingStock(stockCode, price, count);
            return String.format("%s를 %d 가격에 매수하였음", stockCode,price);
        } catch (Exception e) {
            return String.format("%s 매수 중 오류 발생: %s", stockCode, e.getMessage());
        }
    }
}
