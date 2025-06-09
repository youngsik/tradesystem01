public class NamuTradingSystem {
    NamuApi namuApi;

    public NamuTradingSystem() {
        this.namuApi = new NamuApi();
    }
  
    public String login(String id, String password){

        String result = namuApi.login(id, password);
        if (result.equals(NamuApi.NOT_FOUND)){
            namuApi.signUp(id, password);
            result = namuApi.login(id, password);

        }

        return result;
    }
  
    public String sell(String stockCode, int count, int price) {
        return stockCode + "를 " + price + " 가격에 매도하였음";
    }


    public String buy(String stockCode, int count, int price) {
        try {
            namuApi.purchasingStock(stockCode, price, count);
            return String.format("%s를 %d 가격에 매수하였음", stockCode,price);
        } catch (Exception e) {
            return String.format("%s 매수 중 오류 발생: %s", stockCode, e.getMessage());
        }
    }
}
