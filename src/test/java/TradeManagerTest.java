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

    @Test
    void TradeManagerBuy1() {
        String stockCode = "T01";
        int count = 1;
        int price = 1000;
        tradingSystem = new KiumTradingSystem();
        trademanager.selectStockBrocker(tradingSystem);
        String expected = String.format("%s를 %d 가격에 매수하였음", stockCode,price);

        String actual = trademanager.buy(stockCode,count,price);
        assertEquals(actual, expected);
    }

    @Test
    void TradeManagerBuy2() {
        String stockCode = "T01";
        int count = 1;
        int price = 1000;
        tradingSystem = new NemoTradingSystem();
        trademanager.selectStockBrocker(tradingSystem);
        String expected = String.format("%s를 %d 가격에 매수하였음", stockCode,price);

        String actual = trademanager.buy(stockCode,count,price);
        assertEquals(actual, expected);
    }

}