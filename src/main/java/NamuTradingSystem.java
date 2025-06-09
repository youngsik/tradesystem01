public class NamuTradingSystem {
    public String login(String id, String password){
        System.out.println(id + "님 로그인 성공");
        if(password.equals("TEST")){
            throw new LoginFailException(id + "님 로그인 실패");
        }

        return String.format("%s님 로그인 성공", id);
    }
}
