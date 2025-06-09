import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NamuTradingSystemTest {

    public static final String STOCK_CODE = "T02";
    public static final int STOCK_COUNT = 1;
    public static final int STOCK_SELLING_PRICE = 2000;

    @Test
    public void sell() {

        NamuTradingSystem app = new NamuTradingSystem();
        String actual = app.sell(STOCK_CODE, STOCK_COUNT, STOCK_SELLING_PRICE);
        String expected = String.format("%s를 %d 가격에 매도하였음", STOCK_CODE, STOCK_SELLING_PRICE);
        assertEquals(actual, expected);
    }
}
