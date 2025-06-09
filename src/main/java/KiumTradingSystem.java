public class KiumTradingSystem {

    public String buy(String stockCode, int count, int price) {
        return String.format("%s를 %d 가격에 매수하였음", stockCode, price);
    }
}
