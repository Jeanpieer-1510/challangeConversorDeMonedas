package com.piero.Conversor.conexiones;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.piero.Conversor.modelos.Transformacion;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

    public Transformacion convertirMoneda(String moneda, String moneda2, double cantidad) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/233811dc064bdc8b1565f913/pair/" 
                + moneda.toUpperCase()
                + "/" + moneda2.toUpperCase()
                + "/" + cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Error al realizar la petición: Código HTTP " + response.statusCode());
            }

            // Parsear la respuesta JSON
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();

            if (!jsonResponse.has("conversion_rate") || !jsonResponse.has("conversion_result")) {
                throw new RuntimeException("La respuesta de la API no contiene los campos esperados.");
            }

            // Convertir el JSON a la clase Transformacion
            return new Transformacion(
                    jsonResponse.get("base_code").getAsString(),
                    jsonResponse.get("target_code").getAsString(),
                    jsonResponse.get("conversion_rate").getAsDouble(),
                    jsonResponse.get("conversion_result").getAsDouble(),
                    cantidad // Pasar la cantidad original aquí
            );

        } catch (RuntimeException e) {
            throw e; // Re-lanzar excepciones explícitas
        } catch (Exception e) {
            throw new RuntimeException("No se pudo realizar la conversión de la moneda. Error: " + e.getMessage(), e);
        }
    }
}