package Leecode;


import java.util.HashMap;
import java.util.Map;

public class Prob_3_v2 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int max = 1, len = 1;
        Map<Character, Integer> locMap = new HashMap<>();
        locMap.put(s.charAt(0), 0);
        //
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!locMap.containsKey(c)) {//1
                len++;
                locMap.put(c, i);
            } else {
                if (max < len)
                    max = len;
                i = locMap.get(c) + 1;
                len = 1;
                locMap = new HashMap<>();
                locMap.put(s.charAt(i), i);
            }
        }
        if(max < len) {
            max = len;
        }
        return max;

    }

    public static void main(String[] args) {
        Prob_3_v2 prob_3V2 = new Prob_3_v2();

    }
}
