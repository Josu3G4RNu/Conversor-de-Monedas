package Funciones;

import Modelos.Conversion;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {
    public Conversion realizarConversion(String monedaInicial, String monedaFinal, double monto){

        // https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP/AMOUNT
        String url = "https://v6.exchangerate-api.com/v6/b769c3eec0c864a7539fce61/pair/%s/%s/%f".formatted(monedaInicial, monedaFinal, monto);
        URI uri = URI.create(url);

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

        try {
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversion.class);
        } catch (Exception e){
            throw new RuntimeException("Opción no válida.");
        }
    }
}
