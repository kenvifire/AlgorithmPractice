package Leecode;

import utils.AssertUtils;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob_205 {
    static class CharCnt implements Comparable<CharCnt> {
        private int cnt;
        private char ch;
        private int order;

        CharCnt(char ch, int cnt, int order) {
            this.ch = ch;
            this.cnt = cnt;
            this.order = order;
        }

        @Override
        public int compareTo(CharCnt o) {
            if(cnt == o.cnt ) {
                return this.order - o.order;
            } else {
                return this.cnt - o.cnt;
            }

        }
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer>  sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sOrderMap = new HashMap<>();
        Map<Character, Integer> tOrderMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            int value = sMap.getOrDefault(key, 0);
            sMap.put(key, value+1);
            sOrderMap.putIfAbsent(key, i) ;
        }

        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            int value = tMap.getOrDefault(key, 0);
            tMap.put(key, value+1);
            tOrderMap.putIfAbsent(key, i) ;
        }

        List<CharCnt> sList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            sList.add(new CharCnt(entry.getKey(), entry.getValue(), sOrderMap.get(entry.getKey())));
        }

        List<CharCnt> tList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            tList.add(new CharCnt(entry.getKey(), entry.getValue(), tOrderMap.get(entry.getKey())));
        }

        if(sList.size() != tList.size()) return false;

        Collections.sort(sList);
        Collections.sort(tList);

        Map<Character, Character> stMap = new HashMap<>();
        for (int i = 0; i < sList.size(); i++) {
            if(sList.get(i).cnt != tList.get(i).cnt) return false;
            stMap.put(sList.get(i).ch, tList.get(i).ch);

        }
        StringBuilder sbt = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
           sbt.append(stMap.get(s.charAt(i)));
        }

        return sbt.toString().equals(t);
    }

    public static void main(String[] args) {
        Prob_205 prob = new Prob_205();
        AssertUtils.assertFalse(prob.isIsomorphic("baa", "aba"));
        AssertUtils.assertTrue(prob.isIsomorphic("egg", "add"));
        AssertUtils.assertFalse(prob.isIsomorphic("foo", "bar"));
        AssertUtils.assertTrue(prob.isIsomorphic("paper", "title"));
    }
}
