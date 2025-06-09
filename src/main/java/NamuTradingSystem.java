public class NamuTradingSystem {
    private final NamuApi api = new NamuApi();

    public String login(String id, String password){

        String result = api.login(id, password);
        if (result.equals(NamuApi.NOT_FOUND)){
            api.signUp(id, password);
            result = api.login(id, password);

        }

        return result;
    }
}
