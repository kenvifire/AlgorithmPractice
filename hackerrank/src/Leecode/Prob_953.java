package Leecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Prob_953 {


    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();
                int lim = Math.min(len1, len2);
                char v1[] = o1.toCharArray();
                char v2[] = o2.toCharArray();

                int k = 0;
                while (k < lim) {
                    char c1 = v1[k];
                    char c2 = v2[k];
                    if (c1 != c2) {
                        return orderMap.get(c1) - orderMap.get(c2);
                    }
                    k++;
                }
                return len1 - len2;
            }
        };

        for (int i = 0; i < words.length - 1; i++) {
            if (comparator.compare(words[i], words[i + 1]) > 0) return false;
        }
        return true;
    }
}
