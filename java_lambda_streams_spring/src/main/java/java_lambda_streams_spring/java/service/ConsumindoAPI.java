package java_lambda_streams_spring.java.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumindoAPI {
    //enviando a requisição
    public String obterDados(String endereco){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco)).build();
        HttpResponse<String> response = null;

        //tratando as excessoes que podem acontecer
        try{
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        }catch (IOException e){
            throw new RuntimeException(e);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        String json = response.body();
        return json;
    }
}
