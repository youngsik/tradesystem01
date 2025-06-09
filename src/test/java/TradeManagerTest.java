import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TradeManagerTest {

    public static final String ID = "ABC";
    public static final String CORRECT_PW = "BTS";

    public static final String STOCK_CODE = "T01";
    public static final int STOCK_COUNT = 1;
    public static final int STOCK_PRICE = 1000;

    public static final String LOGIN_SUCCESS_RESPONSE = String.format("%s" + "님 로그인 성공", ID);
    public static final String BUY_SUCCESS_RESPONSE = String.format("%s를 %d 가격에 매수하였음", STOCK_CODE, STOCK_PRICE);
    public static final String SELL_SUCCESS_RESPONSE = String.format("%s를 %d 가격에 매도하였음", STOCK_CODE, STOCK_PRICE);

    @Mock
    private TradingSystem tradingSystem;
    private final TradeManager trademanager = TradeManager.getInstance();

    @BeforeEach
    void setUp() {
        trademanager.selectStockBrocker(tradingSystem);
    }

    @Test
    void TradeManagerLoginPass() {
        doReturn(LOGIN_SUCCESS_RESPONSE).when(tradingSystem).login(ID, CORRECT_PW);
        String actual = trademanager.login(ID, CORRECT_PW);
        assertEquals(LOGIN_SUCCESS_RESPONSE, actual);
    }

    @Test
    void TradeManagerLoginPass2() {
        doReturn(LOGIN_SUCCESS_RESPONSE).when(tradingSystem).login(ID, CORRECT_PW);
        String actual = trademanager.login(ID, CORRECT_PW);
        assertEquals(LOGIN_SUCCESS_RESPONSE, actual);
    }

    @Test
    void TradeManagerBuy1() {
        doReturn(BUY_SUCCESS_RESPONSE).when(tradingSystem).buy(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
        String actual = trademanager.buy(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
        assertEquals(BUY_SUCCESS_RESPONSE, actual);
    }

    @Test
    void TradeManagerBuy2() {
        doReturn(BUY_SUCCESS_RESPONSE).when(tradingSystem).buy(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
        String actual = trademanager.buy(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
        assertEquals(BUY_SUCCESS_RESPONSE, actual);
    }

    @Test
    void TradeManagerGetPrice(){
        NemoApi nemoApi = new NemoApi();
        tradingSystem = new NemoTradingSystem(nemoApi);
        trademanager.selectStockBrocker(tradingSystem);

        try {
            when(nemoApi.getMarketPrice(Mockito.anyString(), Mockito.anyInt())).thenReturn(STOCK_PRICE);
        } catch (InterruptedException e) {
            System.out.println("getMarketPrice() 메소드 호출 중 예외 발생: " + e.getMessage());
        }

        int expected = STOCK_PRICE;
        int actual = trademanager.getPrice(STOCK_CODE);

        assertEquals(expected, actual);
    }

    void TradeManagerSell1() {
        doReturn(SELL_SUCCESS_RESPONSE).when(tradingSystem).sell(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
        String actual = trademanager.sell(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
        assertEquals(SELL_SUCCESS_RESPONSE, actual);
    }

    @Test
    void TradeManagerSell2() {
        doReturn(SELL_SUCCESS_RESPONSE).when(tradingSystem).sell(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
        String actual = trademanager.sell(STOCK_CODE, STOCK_COUNT, STOCK_PRICE);
        assertEquals(SELL_SUCCESS_RESPONSE, actual);
    }

    @Test
    void TradeManagerBuyNiceTiming() throws InterruptedException {
        /*성공하면 매수한 주식수 return*/
        doReturn(3).when(tradingSystem).buyNiceTiming(STOCK_CODE, 10000);
        int actual = trademanager.buyNiceTiming(STOCK_CODE, 10000);
        assertEquals(3, actual);
    }

    @Test
    void TradeManagerSellNiceTiming() throws InterruptedException {
        /*성공하면 매수하여 받은 금액 return*/
        doReturn(10000).when(tradingSystem).sellNiceTiming(STOCK_CODE, 3);
        int actual = trademanager.sellNiceTiming(STOCK_CODE, 3);
        assertEquals(10000, actual);
    }
}
