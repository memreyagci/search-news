package org.memreyagci.searchnews;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FetchData {

    private final String baseUrl = "https://newsapi.org/v2/everything";
    private String apiKey;

    public FetchData() {
        File apiKeyFile = new File(System.getProperty("user.dir") + "/src/main/java/org/memreyagci/searchnews/IgnoreThis/api_key.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(apiKeyFile));
            // TODO : apiKey will be provided by the user.
            while ((apiKey = br.readLine()) != null) System.out.println(apiKey);
            br.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public String Deneme() {

        HttpResponse<JsonNode> httpResponse = Unirest.get(baseUrl)
                .queryString("apiKey", apiKey)
                .asJson();

        String result = httpResponse.getBody().toPrettyString();

        return result;
    }
}
