package Leecode;

import utils.MapUtils;
import utils.StringUtils;

import java.util.Map;

public class Prob_242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> cntMap1 = StringUtils.strToCntMap(s);
        Map<Character, Integer> cntMap2 = StringUtils.strToCntMap(t);

        return MapUtils.countMapContains(cntMap1, cntMap2);

    }
}
