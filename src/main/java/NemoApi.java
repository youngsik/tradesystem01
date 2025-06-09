import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class NemoApi {
    public static final String NOT_FOUND = "NOT FOUND";
    private final Map<String, String> userDb;

    public NemoApi() {
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

    public void certification( String ID, String Pass) {
        System.out.println("[네모]" + ID + "님 로그인 성공");
    }

    public void purchasingStock( String stockCode,int price, int count){
        System.out.println("[네모]" + stockCode + "를 " + price + "가격에 매수하였음");
    }

    public void sellingStock( String stockCode , int price, int count) {
        System.out.println("[네모]" + stockCode + "를 " + price + "가격에 매도하였음");
    }

    public int getMarketPrice ( String stockCode, int minute) throws InterruptedException {
        //minute ms초 이후 구매가 되는 방식 (최소 1 ms)
        if (minute <= 0) minute = 1;
        Thread.sleep(minute);
        Random random = new Random();
        return random.nextInt() % 10 * 100 + 5000;
    }
}
