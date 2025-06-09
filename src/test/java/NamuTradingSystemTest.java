import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NamuTradingSystemTest {

    private NamuTradingSystem app;

    @BeforeEach
    void setUp() {
        app = new NamuTradingSystem();
    }

    @Test
    void namuloginpass() {
        String id = "ABC";
        String password = "BTS";

        String actual = app.login(id,password);
        String expected = String.format("%s님 로그인 성공", id);

        assertEquals(actual, expected);
    }

    @Test
    void namuloginfail() {
        app.login("ABC", "BTS");
        String id = "ABC";
        String password = "TEST";

        assertThrows(LoginFailException.class, () ->
                app.login(id, password));
    }
}