import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class mainTest {
    @Test
    void kiumloginpass() {
        String id = "ABC";
        String password = "BTS";

        Login app = new Login(id,password);

        assertEquals(actual, expected);
    }

    void kiumloginfail() {
        String id = "ABC";
        String password = "BTS";

        Login app = new Login(id,password);

        assertEquals(actual, expected);
    }


    @Test
    void nemologinpass() {
        String id = "ABC";
        String password = "BTS";

        Login app = new Login(id,password);

        assertEquals(actual, expected);
    }

    @Test
    void nemologinfail() {
        String id = "ABC";
        String password = "BTS";

        Login app = new Login(id,password);

        assertEquals(actual, expected);
    }
}