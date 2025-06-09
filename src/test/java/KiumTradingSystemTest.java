import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

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
}