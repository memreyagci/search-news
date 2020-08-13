package org.memreyagci.searchnews.newsapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class NewsApiUrl {
    private static final String baseUrl = "https://newsapi.org/v2/everything?";
    private static final String keywords = "q=";
    private static final String title = "qInTitle=";
    private static final String dateFrom = "from=";
    private static final String dateTo = "to=";
    private static final String sortBy = "sortBY=";
    private static final String domains = "domains=";
    private static final String languages = "language=";
    private static String apiKey;
    private static String url;

    public static String getUrl(NewsApi newsApi) {
        url = baseUrl + keywords + newsApi.getProvidedKeyword() + "&"
                + title + newsApi.getProvidedTitle() + "&"
                + domains + newsApi.getProvidedDomain() + "&"
                + dateFrom + newsApi.getProvidedDateFrom() + "&"
                + dateTo + newsApi.getProvidedDateTo() + "&"
                + sortBy + newsApi.getProvidedSortBy() + "&"
                + "apiKey=" + getApiKey();

        System.out.println("URL:    " + url);

        return url;
    }

    // TODO : Get the api key from user when the application is first run.
    private static String getApiKey() {
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
}
