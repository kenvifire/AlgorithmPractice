package Leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prob_819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> cntMap = new HashMap<>();
        StringBuilder sb = null;
        for (int i = 0; i < paragraph.length(); i++) {
            char ch = paragraph.charAt(i);
            if(Character.isAlphabetic(ch)) {
                if(sb == null) {
                    sb = new StringBuilder();
                    sb.append(Character.toLowerCase(ch));
                } else {
                    sb.append(Character.toLowerCase(ch));
                }
            } else {
                if (sb != null) {
                    String word = sb.toString();
                    int value = cntMap.getOrDefault(word, 0);
                    cntMap.put(word, value + 1);
                    sb = null;
                }
            }

        }

        if(sb!=null) {
            String word = sb.toString();
            int value = cntMap.getOrDefault(word, 0);
            cntMap.put(word, value + 1);
        }

        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
           bannedSet.add(word);
        }

        int max = -1;
        String maxWorld = null;
        for(Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            if(entry.getValue() > max && !bannedSet.contains(entry.getKey())) {
               maxWorld = entry.getKey();
               max = entry.getValue();
            }
        }

        return maxWorld;

    }

    public static void main(String[] args) {
        Prob_819 prob = new Prob_819();
        System.out.println(prob.mostCommonWord("Bob", new String[]{}));
    }
}
