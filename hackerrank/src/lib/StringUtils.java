package lib;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kenvi on 2017/12/28.
 */
public class StringUtils {
    public static Map<Character, Integer> str2CharMap(String s) {
        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            Integer value = charMap.get(key);

            if(value != null) {
                charMap.put(key, value + 1);
            } else {
                charMap.put(key, 1 );
            }
        }

        return charMap;
    }
}
