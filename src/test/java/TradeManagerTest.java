import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TradeManagerTest {
    @Mock
    NemoApi nemoApi;

    public static final String ID = "ABC";
    public static final String CORRECT_PW = "BTS";
    public static final String LOGIN_SUCCESS_LOG = "님 로그인 성공";

    private TradingSystem tradingSystem ;
    private final TradeManager trademanager= TradeManager.getInstance();

    @Test
    void TradeManagerLoginPass() {
        tradingSystem = new KiumTradingSystem();
        trademanager.selectStockBrocker(tradingSystem);
        String expected = String.format("%s" + LOGIN_SUCCESS_LOG, ID);

        String actual = trademanager.login(ID, CORRECT_PW);
        assertEquals(actual, expected);
    }

    @Test
    void TradeManagerLoginPass2() {
        tradingSystem = new NemoTradingSystem(nemoApi);
        trademanager.selectStockBrocker(tradingSystem);
        String expected = String.format("%s" + LOGIN_SUCCESS_LOG, ID);
        Mockito.doNothing().when(nemoApi).certification(ID, CORRECT_PW);

        String actual = trademanager.login(ID, CORRECT_PW);
        assertEquals(actual, expected);
    }
}