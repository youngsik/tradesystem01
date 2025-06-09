import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KiumTradingSystemTest {
    @Test
    void kiumsellpass() {
        String stockCode = "T02";
        int count = 1;
        int price = 2000;

        KiumTradingSystem app = new KiumTradingSystem();
        String actual = app.buy(stockCode,count,price);
        String expected = String.format("%s를 %d 가격에 매도하였음", stockCode, price);
        assertEquals(actual, expected);
    }
}