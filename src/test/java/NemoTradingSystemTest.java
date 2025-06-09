import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NemoTradingSystemTest {
    @Mock
    NemoApi nemoApi;

    private NemoTradingSystem app;

    public static final String STOCK_CODE = "T02";
    public static final int STOCK_COUNT = 1;
    public static final int STOCK_SELLING_PRICE = 2000;
    public static final int GET_PRICE_MINUTE = 1;

    @BeforeEach
    void setUp() {
        app = new NemoTradingSystem(nemoApi);
    }

    @Test
    void namuloginpass() {
        String id = "ABC";
        String password = "BTS";

        KiumTradingSystem app = new KiumTradingSystem();
        String actual = app.login(id, password);
        String expected = String.format("%s님 로그인 성공", id);
        assertEquals(actual, expected);
    }

    @Test
    void namuloginfail() {
        String id = "ABC";
        String password = "TEST";

        KiumTradingSystem app = new KiumTradingSystem();
        String actual = app.login(id, password);
        String expected = String.format("%s님 로그인 실패", id);
        assertEquals(actual, expected);
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

    @Test
    void nemogetprice() throws InterruptedException {
        int expected = 2000;
        when(nemoApi.getMarketPrice(STOCK_CODE,GET_PRICE_MINUTE)).thenReturn(2000);

        int actual = app.getPrice(STOCK_CODE);
        assertEquals(expected, actual);
    }

    @Test
    void nemoSellNiceTiming() throws InterruptedException {
        NemoTradingSystem app = new NemoTradingSystem(nemoApi);

        app.sellNiceTiming(STOCK_CODE,10000);
        verify(nemoApi, times(3)).getMarketPrice(STOCK_CODE,1);
    }
}
