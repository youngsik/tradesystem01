import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KiumTradingSystemTest {

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
}