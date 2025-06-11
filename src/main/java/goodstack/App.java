package goodstack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {
    public static void main(String[] args) {
        String apiUrl = System.getenv("API_URL");

        if (apiUrl == null || apiUrl.isEmpty()) {
            System.out.println("API_URL environment variable is not set.");
            return;
        }

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Print response headers
            connection.getHeaderFields().forEach((key, value) -> {
                System.out.println(key + ": " + value);
            });

            // Print response body
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println("Response Body: " + response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
