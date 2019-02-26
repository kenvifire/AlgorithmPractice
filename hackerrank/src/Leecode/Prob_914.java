package Leecode;

import utils.AssertUtils;

import java.util.HashMap;
import java.util.Map;

public class Prob_914 {
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length == 0) return false;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int d : deck) {
            int value = cntMap.getOrDefault(d, 0 );
            cntMap.put(d, value + 1);
        }

        if(cntMap.size() == 1 && deck.length >= 2) return true;
        int commGcd =  - 1;

        for (int val : cntMap.values()) {
            if(commGcd == -1) {
                commGcd = val;
            } else {
                commGcd = gcd(commGcd, val);
                if(commGcd <2) return false;

            }

        }

        return commGcd >= 2;
    }


    private int gcd(int a, int b) {
        if(b == 0) return a;
        return a % b == 0 ? b : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Prob_914 prob = new Prob_914();

        AssertUtils.assertTrue(prob.hasGroupsSizeX(new int[] {1,2,3,4,4,3,2,1}));
        AssertUtils.assertTrue(prob.hasGroupsSizeX(new int[] {1,1}));
        AssertUtils.assertFalse(prob.hasGroupsSizeX(new int[] {1,2}));
        AssertUtils.assertFalse(prob.hasGroupsSizeX(new int[] {1,2, 2}));
        AssertUtils.assertFalse(prob.hasGroupsSizeX(new int[] {1,2, 2, 3, 3}));
        AssertUtils.assertFalse(prob.hasGroupsSizeX(new int[] {1,2, 2, 3, 3, 3, 3}));
        AssertUtils.assertFalse(prob.hasGroupsSizeX(new int[] {1}));
        AssertUtils.assertFalse(prob.hasGroupsSizeX(new int[] {}));
        AssertUtils.assertFalse(prob.hasGroupsSizeX(new int[] {1,1,1,2,2,2,3,3}));
    }
}
