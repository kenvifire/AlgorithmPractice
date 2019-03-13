package Leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob_451 {
    static class Char implements Comparable<Char> {
        private char ch;
        private int cnt = 0;

        public Char(char ch, int cnt) {
           this.ch = ch;
           this.cnt = cnt;
        }


        @Override
        public int compareTo(Char that) {
            if(this.cnt == that.cnt) {
               return this.ch - that.ch;
            } else {
                return that.cnt - this.cnt;
            }
        }
    }
    public String frequencySort(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int val = cntMap.getOrDefault(s.charAt(i), 0);
            cntMap.put(s.charAt(i), val + 1);
        }

        List<Char> charList = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            charList.add(new Char(entry.getKey(), entry.getValue()));
        }
        Collections.sort(charList);

        StringBuilder sb = new StringBuilder();

        for (Char ch: charList) {
            for (int i = 0; i < ch.cnt; i++) {
                sb.append(ch.ch);
            }
        }
        return sb.toString();


    }
}
