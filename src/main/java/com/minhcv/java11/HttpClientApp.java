package com.minhcv.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientApp {
    public static void main(String[] args) throws Exception {
        HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).connectTimeout(Duration.ofSeconds(3))
                .build();
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://www.google.com.vn/")).build();
        HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("End");
    }
}
