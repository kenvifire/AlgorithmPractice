package Leecode;

import java.util.HashMap;
import java.util.Map;

public class Codec {
    Map<String,String> urlMap = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int hashCode = longUrl.hashCode();
        urlMap.put(String.valueOf(hashCode), longUrl);
        return String.valueOf(longUrl.hashCode());

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMap.get(shortUrl);
    }
}
