import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TradeManagerTest {

    public static final String ID = "ABC";
    public static final String CORRECT_PW = "BTS";
    public static final String LOGIN_SUCCESS_LOG = "님 로그인 성공";

    public static final String STOCK_CODE = "T01";
    public static final int STOCK_COUNT = 1;
    public static final int STOCK_PRICE = 1000;

    @Mock
    private TradingSystem tradingSystem ;
    private final TradeManager trademanager= TradeManager.getInstance();

    @Test
    void TradeManagerLoginPass() {
        trademanager.selectStockBrocker(tradingSystem);
        String expected = String.format("%s" + LOGIN_SUCCESS_LOG, ID);
        doReturn(ID + LOGIN_SUCCESS_LOG).when(tradingSystem).login(ID, CORRECT_PW);

        String actual = trademanager.login(ID, CORRECT_PW);
        assertEquals(expected, actual);
    }

    @Test
    void TradeManagerLoginPass2() {
        trademanager.selectStockBrocker(tradingSystem);
        String expected = String.format("%s" + LOGIN_SUCCESS_LOG, ID);
        doReturn(ID + LOGIN_SUCCESS_LOG).when(tradingSystem).login(ID, CORRECT_PW);

        String actual = trademanager.login(ID, CORRECT_PW);
        assertEquals(expected, actual);
    }

    @Test
    void TradeManagerBuy1() {
        trademanager.selectStockBrocker(tradingSystem);
        String expected = String.format("%s를 %d 가격에 매수하였음", STOCK_CODE, STOCK_PRICE);
        doReturn(expected).when(tradingSystem).buy(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);

        String actual = trademanager.buy(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
        assertEquals(expected, actual);
    }

    @Test
    void TradeManagerBuy2() {
        trademanager.selectStockBrocker(tradingSystem);
        String expected = String.format("%s를 %d 가격에 매수하였음", STOCK_CODE, STOCK_PRICE);
        doReturn(expected).when(tradingSystem).buy(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);

        String actual = trademanager.buy(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
        assertEquals(expected, actual);
    }

    @Test
    void TradeManagerSell1() {
        trademanager.selectStockBrocker(tradingSystem);
        String expected = String.format("%s를 %d 가격에 매도하였음", STOCK_CODE, STOCK_PRICE);
        doReturn(expected).when(tradingSystem).sell(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);

        String actual = trademanager.sell(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
        assertEquals(expected, actual);
    }

    @Test
    void TradeManagerSell2() {
        trademanager.selectStockBrocker(tradingSystem);
        String expected = String.format("%s를 %d 가격에 매도하였음", STOCK_CODE, STOCK_PRICE);
        doReturn(expected).when(tradingSystem).sell(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);

        String actual = trademanager.sell(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
        assertEquals(expected, actual);
    }

}