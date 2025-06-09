import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TradeManagerTest {
    @Mock
    NemoApi nemoApi;

    public static final String ID = "ABC";
    public static final String CORRECT_PW = "BTS";
    public static final String LOGIN_SUCCESS_LOG = "님 로그인 성공";

    public static final String STOCK_CODE = "T01";
    public static final int STOCK_COUNT = 1;
    public static final int STOCK_PRICE = 1000;

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

    @Test
    void TradeManagerBuy1() {
        tradingSystem = new KiumTradingSystem();
        trademanager.selectStockBrocker(tradingSystem);
        String expected = String.format("%s를 %d 가격에 매수하였음", STOCK_CODE, STOCK_PRICE);

        String actual = trademanager.buy(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
        assertEquals(actual, expected);
    }

    @Test
    void TradeManagerBuy2() {
        tradingSystem = new NemoTradingSystem();
        trademanager.selectStockBrocker(tradingSystem);
        String expected = String.format("%s를 %d 가격에 매수하였음", STOCK_CODE, STOCK_PRICE);

        String actual = trademanager.buy(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
        assertEquals(actual, expected);
    }

}