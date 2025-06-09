import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NemoTradingSystemTest {
    @Test
    void nemobuypass() {
        String stockCode = "T01";
        int count = 1;
        int price = 1000;

        NamuTradingSystem app = new NamuTradingSystem();
        String actual = app.buy(stockCode,count,price);
        String expected = String.format("%s를 %d 가격에 매수하였음", stockCode,price);
        assertEquals(actual, expected);
    }

}