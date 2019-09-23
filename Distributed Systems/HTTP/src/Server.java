import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Server {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8700), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(Server::handleRequest);
        server.start();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        InputStream in = exchange.getRequestBody();

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("value", null);
        try {
            jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader(in, "UTF-8"));
        }catch(ParseException e){}

        String response = (String)jsonObject.get("value");
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
