import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KiumTradingSystemTest {

    private static final String STOCK_CODE = "T01";
    private static final int STOCK_COUNT = 1;
    private static final int STOCK_PRICE = 1000;

    private KiumTradingSystem kiumTradingSystem;

    @BeforeEach
    void setUp() {
        kiumTradingSystem = new KiumTradingSystem();
    }

    @Test
    void kiumbuypass() {
        String actual = kiumTradingSystem.buy(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
        String expected = String.format("%s를 %d 가격에 매수하였음", STOCK_CODE, STOCK_PRICE);

        assertEquals(actual, expected);
    }
}