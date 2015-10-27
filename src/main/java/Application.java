import domain.ResponseData;
import web.RestClient;

public class Application {

    public static void main(String[] args) {
        RestClient restClient = new RestClient();
        ResponseData data = restClient.sendPostRequest();
        restClient.parseRequestResult(data);
    }
}
