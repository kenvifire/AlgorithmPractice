package Leecode;

import utils.AssertUtils;

import java.util.HashMap;
import java.util.Map;

public class Prob_290 {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> patternMap = new HashMap<>();
        String[] array = str.split(" ");

        if(pattern.length() != array.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String strToMap = array[i];;
            if(patternMap.containsKey(ch)){
                if(!patternMap.get(ch).equals(strToMap)) return false;
            } else {
                if(patternMap.values().contains(strToMap)) return false;
                patternMap.put(ch, strToMap);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Prob_290 prob = new Prob_290();

        AssertUtils.assertTrue(prob.wordPattern("abba", "dog cat cat dog"));
        AssertUtils.assertFalse(prob.wordPattern("abba", "dog cat cat fish"));
        AssertUtils.assertFalse(prob.wordPattern("aaaa", "dog cat cat dog"));
        AssertUtils.assertFalse(prob.wordPattern("abba", "dog dog dog dog"));
    }
}
