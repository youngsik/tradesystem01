import java.util.HashMap;
import java.util.Map;

public class NamuTradingSystem {
    private final Map<String, String> userDb;

    public NamuTradingSystem() {
        this.userDb = new HashMap<>();
    }

    public String login(String id, String password){
        userDb.putIfAbsent(id, password);

        if(!userDb.get(id).equals(password)){
            throw new LoginFailException(id + "님 로그인 실패");
        }

        System.out.println(id + "님 로그인 성공");
        return String.format("%s님 로그인 성공", id);
    }
}
