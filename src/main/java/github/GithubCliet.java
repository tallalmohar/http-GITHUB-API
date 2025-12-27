package github;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GithubCliet {
    private String username = "tallalmohar";
    private final String url = "https://api.github.com/users/" + this.username + "/events/public";

    private final HttpClient client;

    public GithubCliet(){
        this.client = HttpClient.newHttpClient();
    }

    public String getEvents(){
        HttpRequest request= HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .GET().build();
        try {
            HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
            return res.body();
        }catch (InterruptedException | IOException e){
            System.out.println("Error");
        }
        return "";
    }
}
