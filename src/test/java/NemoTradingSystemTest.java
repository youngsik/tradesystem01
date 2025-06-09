import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NemoTradingSystemTest {

    private NemoTradingSystem app;

    public static final String STOCK_CODE = "T02";
    public static final int STOCK_COUNT = 1;
    public static final int STOCK_SELLING_PRICE = 2000;

    @BeforeEach
    void setUp() {
        app = new NemoTradingSystem();
    }

    @Test
    void namuloginpass() {
        String id = "ABC";
        String password = "BTS";

        String actual = app.login(id,password);
        String expected = String.format("%s님 로그인 성공", id);

        assertEquals(actual, expected);
    }

    @Test
    void namuloginfail() {
        app.login("ABC", "BTS");
        String id = "ABC";
        String password = "TEST";

        assertThrows(LoginFailException.class, () ->
                app.login(id, password));
    }

    @Test
    public void sell() {
        String actual = app.sell(STOCK_CODE, STOCK_COUNT, STOCK_SELLING_PRICE);
        String expected = String.format("%s를 %d 가격에 매도하였음", STOCK_CODE, STOCK_SELLING_PRICE);
        assertEquals(actual, expected);
    }

    @Test
    void nemobuypass() {
        String stockCode = "T01";
        int count = 1;
        int price = 1000;
        String actual = app.buy(stockCode,count,price);
        String expected = String.format("%s를 %d 가격에 매수하였음", stockCode,price);
        assertEquals(actual, expected);
    }
}
