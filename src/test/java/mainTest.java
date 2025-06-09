import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class mainTest {
    @Test
    void kiumloginpass() {
        String id = "ABC";
        String password = "BTS";

        KiumTradingSystem app = new KiumTradingSystem();
        String actual = app.login(id,password);
        String expected = String.format("%s님 로그인 성공", id);
        assertEquals(actual, expected);
    }

    void kiumloginfail() {
        String id = "ABC";
        String password = "TEST";

        KiumTradingSystem app = new KiumTradingSystem();
        String actual = app.login(id,password);
        String expected = String.format("%s님 로그인 실패", id);
        assertEquals(actual, expected);
    }


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