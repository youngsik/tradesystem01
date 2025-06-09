import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class KiumTradingSystemTest {

    private static final String STOCK_CODE = "T01";
    private static final int STOCK_COUNT = 1;
    private static final int STOCK_PRICE = 1000;

    @Mock
    private KiwerAPI mockKiwerAPI;

    @InjectMocks
    private KiumTradingSystem kiumTradingSystem;

    @Test
    void kiumloginpass() {
        String id = "ABC";
        String password = "BTS";

        KiumTradingSystem app = new KiumTradingSystem();
        String actual = app.login(id, password);
        String expected = String.format("%s님 로그인 성공", id);
        assertEquals(actual, expected);
    }

    @Test
    void kiumloginfail() {
        String id = "ABC";
        String password = "TEST";

        KiumTradingSystem app = new KiumTradingSystem();
        String actual = app.login(id, password);
        String expected = String.format("%s님 로그인 실패", id);
        assertEquals(actual, expected);
    }

    @Test
    void kiumbuytest_verifyapicall() {
        kiumTradingSystem.buy(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
        verify(mockKiwerAPI).buy(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
    }

    @Test
    void kiumbuytest_pass() {
        String actual = kiumTradingSystem.buy(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
        String expected = String.format("%s를 %d 가격에 매수하였음", STOCK_CODE, STOCK_PRICE);

        assertEquals(actual, expected);
    }

    @Test
    void kiumsellpass() {
        String stockCode = "T02";
        int count = 1;
        int price = 2000;

        KiumTradingSystem app = new KiumTradingSystem();
        String actual = app.sell(stockCode,count,price);
        String expected = String.format("%s를 %d 가격에 매도하였음", stockCode, price);
        assertEquals(actual, expected);
    }

    @Test
    void kiumgetprice() {
        String stockCode = "T02";
        int expected = 2000;
        when(mockKiwerAPI.currentPrice(stockCode)).thenReturn(expected);

        KiumTradingSystem app = new KiumTradingSystem(mockKiwerAPI);
        int actual = app.getPrice(stockCode);

        assertEquals(actual, expected);
    }


    @Test
    void kiumBuyNiceTiming() {
        KiumTradingSystem app = new KiumTradingSystem(mockKiwerAPI);

        app.buyNiceTiming(STOCK_CODE,10000);
        verify(mockKiwerAPI, times(3)).currentPrice(STOCK_CODE);
    }
}
