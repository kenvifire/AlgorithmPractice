package Leecode;

import java.util.HashMap;
import java.util.Map;

public class Prob_387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            int value = cntMap.getOrDefault(s.charAt(i), 0);
            cntMap.put(s.charAt(i), value + 1);
        }



        for (int i = 0; i < s.length(); i++) {
            if(cntMap.get(s.charAt(i)) == 1)  return i;
        }

        return -1;

    }
}
