import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NamuTradingSystemTest {
    @Test
    void nemologinpass() {
        String id = "ABC";
        String password = "BTS";

        NamuTradingSystem app = new NamuTradingSystem();
        String actual = app.login(id,password);
        String expected = String.format("%s님 로그인 성공", id);

        assertEquals(actual, expected);
    }

    @Test
    void nemologinfail() {
        String id = "ABC";
        String password = "TEST";

        NamuTradingSystem app = new NamuTradingSystem();
        String actual = app.login(id,password);
        String expected = String.format("%s님 로그인 실패", id);
        assertEquals(actual, expected);
    }
}