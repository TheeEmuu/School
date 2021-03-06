import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    public static void main(String[] args){
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .proxy(ProxySelector.of(new InetSocketAddress("/", 8600)))
                .build();

        JSONObject req = new JSONObject();
        req.put("id", 123456);
        req.put("value", "test");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("127.0.0.1"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(req.toJSONString()))
                .build();

        try {
            HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

            byte[] body = response.body();
            StringBuilder build = new StringBuilder();
            for (byte aBody : body) {
                build.append(aBody);
            }
            String res = build.toString();

            System.out.println(res);
        } catch (InterruptedException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
