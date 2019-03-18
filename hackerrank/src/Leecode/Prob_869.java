package Leecode;

import utils.AssertUtils;

import java.util.HashMap;
import java.util.Map;

public class Prob_869 {
    public boolean reorderedPowerOf2(int N) {
        String[] power2 = new String[32];
        for (int i = 0; i <= 31; i ++) {
            power2[i] = String.valueOf(1 << i);
        }

        Map<Character, Integer> numMap = toMap(String.valueOf(N));
        for (int i = 0; i <= 31; i++) {
           Map<Character, Integer>  currMap = toMap(String.valueOf(power2[i]));
           if(mapEq(currMap, numMap)) return true;
        }
        return false;
    }

    private Map<Character, Integer> toMap(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            int val = map.getOrDefault(ch, 0);
            map.put(ch, val + 1);
        }
        return map;
    }

    private boolean mapEq(Map<Character, Integer> left, Map<Character, Integer> right) {
        if(left.size() != right.size()) return false;

        for (Map.Entry<Character, Integer>l : left.entrySet()) {
            if(!right.containsKey(l.getKey()) || !right.get(l.getKey()).equals(l.getValue())) {
                return false;
            }
        }

        for (Map.Entry<Character, Integer> r : right.entrySet()) {
            if(!left.containsKey(r.getKey()) || !left.get(r.getKey()).equals(r.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Prob_869 prob = new Prob_869();

        AssertUtils.assertTrue(prob.reorderedPowerOf2(1));
        AssertUtils.assertTrue(prob.reorderedPowerOf2(16));
        AssertUtils.assertTrue(prob.reorderedPowerOf2(46));
        AssertUtils.assertFalse(prob.reorderedPowerOf2(10));
        AssertUtils.assertFalse(prob.reorderedPowerOf2(24));
    }


}
