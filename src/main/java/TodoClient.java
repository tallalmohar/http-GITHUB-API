import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class TodoClient {
    private HttpClient client;
    private String url = "https://jsonplaceholder.typicode.com/todos";
    private final ObjectMapper objectMapper;

    TodoClient( ) {
        this.client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public List<Todo> getTodos( ) {
        HttpRequest req  = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> res = client.send(req,HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(res.body(), new TypeReference<>() {});
        } catch (IOException | InterruptedException e){
            System.err.print("ERROR IN API CATCH BLOCK");
        }
        return List.of();
    }
}
