package Leecode;

import java.util.HashMap;
import java.util.Map;

public class Prob_791 {

    public String customSortString(String S, String T) {
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < T.length(); i++) {
            int val = tMap.getOrDefault(T.charAt(i), 0);
            tMap.put(T.charAt(i), val + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char curr = S.charAt(i);
            int val = tMap.getOrDefault(curr, 0);
            while (val --> 0) sb.append(curr);
            tMap.remove(curr);
        }

        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            while (val --> 0) sb.append(key);
        }

        return sb.toString();


    }
}
