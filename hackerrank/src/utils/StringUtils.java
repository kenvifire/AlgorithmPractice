package utils;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {
    public static Map<Character, Integer> strToCntMap(String str) {
        Map<Character, Integer> cntMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            int value = cntMap.getOrDefault(str.charAt(i), 0);
            cntMap.put(str.charAt(i), value + 1);
        }
        return cntMap;
    }
}
