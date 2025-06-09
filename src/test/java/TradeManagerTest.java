import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TradeManagerTest {

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
        tradingSystem = new NemoTradingSystem();
        trademanager.selectStockBrocker(tradingSystem);
        String expected = String.format("%s" + LOGIN_SUCCESS_LOG, ID);

        String actual = trademanager.login(ID, CORRECT_PW);
        assertEquals(actual, expected);
    }
}