package Leecode;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob_438 {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();

        for (int i = 0; i < p.length(); i ++) {
            char sKey = s.charAt(i);
            int sValue = sMap.getOrDefault(sKey, 0);
            sMap.put(sKey, sValue + 1);

            char pKey = p.charAt(i);
            int pValue = pMap.getOrDefault(pKey, 0);
            pMap.put(pKey, pValue + 1);
        }

        if(mapEquas(sMap, pMap)) result.add(0);


        int len  = p.length();
        for (int i = p.length(); i < s.length(); i++) {
            char key = s.charAt(i);
            int value = sMap.getOrDefault(key, 0) ;
            sMap.put(key, value + 1);

            char rmKey = s.charAt(i - len);
            value = sMap.getOrDefault(rmKey, 0);
            if(value == 1) {
                sMap.remove(rmKey);
            } else {
                sMap.put(rmKey, value - 1);
            }

            if(mapEquas(sMap, pMap)) result.add(i - p.length() + 1);
        }
        return result;


    }

    private boolean mapEquas(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if(map1.size() != map2.size()) return false;

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if(value != map2.getOrDefault(key, 0))  {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Prob_438 prob = new Prob_438();
        PrintUtils.printIntList(prob.findAnagrams("cbaebabacd", "abc"));
        PrintUtils.printIntList(prob.findAnagrams("abcba", "abc"));
        PrintUtils.printIntList(prob.findAnagrams("aca", "abc"));
    }
}
