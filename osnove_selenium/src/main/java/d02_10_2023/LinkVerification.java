package d02_10_2023;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LinkVerification {

    public static int getHTTPResponseStatusCode(String link) throws IOException {
        URL url = new URL(link);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        return http.getResponseCode();
    }

}
