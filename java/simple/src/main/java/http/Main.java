package http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    static void main() {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.thecatapi.com/v1/images/search?limit=10"))
                .build();
        httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}
