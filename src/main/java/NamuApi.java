import java.util.HashMap;
import java.util.Map;

public class NamuApi {
    public static final String NOT_FOUND = "NOT FOUND";
    private final Map<String, String> userDb;

    public NamuApi() {
        this.userDb = new HashMap<>();
    }

    public void signUp(String id, String password){
        if (userDb.get(id) != null){
            throw new AlreadyExistUserException("이미 회원이 존재 합니다.");
        }

        userDb.putIfAbsent(id, password);
    }

    public String login(String id, String password){
        if(userDb.get(id) == null){
            return NOT_FOUND;
        }

        if(!userDb.get(id).equals(password)){
            throw new LoginFailException(id + "님 로그인 실패");
        }

        System.out.println(id + "님 로그인 성공");
        return String.format("%s님 로그인 성공", id);
    }
}
