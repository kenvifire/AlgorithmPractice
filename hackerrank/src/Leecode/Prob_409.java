package Leecode;

import java.util.HashMap;
import java.util.Map;

public class Prob_409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int value = cntMap.getOrDefault(s.charAt(i), 0);
            cntMap.put(s.charAt(i), value + 1);
        }

        int total = 0 ;
        boolean oddTag = false;

        for (int v : cntMap.values()) {
            if(v >= 2) {
                total += v / 2;
            }

            if(v % 2 == 1) oddTag = true;
        }

        return total * 2 + (oddTag ? 1 : 0);
    }
}
