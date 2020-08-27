package chapter23networking;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;

class HttpClientDemo {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        // Obtain a client that uses the default settings.
        HttpClient myHC = HttpClient.newHttpClient();

        // Create a request.
        HttpRequest myReq = HttpRequest.newBuilder(new URI("http://www.google.com/")).build();

        // Send the request and get the response. Here, an InputStream is used for the body.
        HttpResponse<String> myResp = myHC.send(myReq, HttpResponse.BodyHandlers.ofString());
        // HttpResponse<InputStream> myResp = myHC.send(myReq, HttpResponse.BodyHandlers.ofInputStream());

        // Display response code and request method.
        System.out.println("Response code is " + myResp.statusCode());
        System.out.println("Request method is " + myReq.method());

        // Get headers from the response.
        HttpHeaders hdrs= myResp.headers();

        // Get a map of the headers.
        Map<String, List<String>> hdrMap = hdrs.map();
        Set<String> hdrField = hdrMap.keySet();

        System.out.println("\nHere is the header:");

        // Display all header keys and values.
        for (String k : hdrField) {
            System.out.println("Key: " + k + " Value: " + hdrMap.get(k));
        }

        // Display the body,
        System.out.println("\nHere is the body: ");

        /*
        InputStream inputStream = myResp.body();
        int c;
        // Read and display the entire body.
        while ((c = inputStream.read()) != -1) {
            System.out.print((char) c);
        }

         */

        System.out.println(myResp.body());

    }
}
