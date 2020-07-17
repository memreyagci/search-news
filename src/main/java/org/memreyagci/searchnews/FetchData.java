package org.memreyagci.searchnews;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FetchData {
    private final String baseUrl = "https://newsapi.org/v2/everything?";
    private final String keywords = "q=";
    private final String dateFrom = "from=";
    private final String dateTo = "to=";
    private final String sortBy = "sortBY=";
    private final String domains = "domains=";
    private final String languages = "language=";
    private String apiKey;

    public FetchData() {
    }


    // TODO : Get the api key from user when the application is first run.
    public String getApiKey() {
        File apiKeyFile = new File(System.getProperty("user.dir") + "/src/main/java/org/memreyagci/searchnews/IgnoreThis/api_key.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(apiKeyFile));
            while ((apiKey = br.readLine()) != null) return apiKey;
            br.close();
        }
        catch (Exception e) {
            System.out.println("Hello" + e);
        }
        return apiKey;
    }

    public void FetchNews(NewsApiModel newsApiModel){
        String urlToSearch = baseUrl + keywords + newsApiModel.getProvidedKeyword() + "&"
                + dateFrom + newsApiModel.getProvidedDateFrom() + "&"
                + dateTo + newsApiModel.getProvidedDateTo() + "&"
                + "apiKey=" + getApiKey();

        HttpResponse<JsonNode> httpResponse = Unirest.get(urlToSearch)
                .asJson();

        System.out.println(urlToSearch);

        String result = httpResponse.getBody().toPrettyString();

        System.out.println(result);

    }
}
