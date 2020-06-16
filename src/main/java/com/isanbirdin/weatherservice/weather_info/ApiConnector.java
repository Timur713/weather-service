package com.isanbirdin.weatherservice.weather_info;

import org.json.JSONException;
import org.springframework.context.annotation.PropertySource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConnector {

    public static String makeRequest(String city, String URL, String HTTP_METHOD) throws IOException {
        try {
            URL url = new URL(URL + city);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(HTTP_METHOD);

            String response = handleResponse(con);

            con.disconnect();

            return response;
        } catch (RuntimeException e) {
            throw new JSONException(String.format("Request on url %s is invalid", URL));
        }
    }

    private static String handleResponse(HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        return content.toString();
    }
}
