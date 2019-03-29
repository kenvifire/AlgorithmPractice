package Leecode;

import utils.AssertUtils;

import java.util.HashSet;
import java.util.Set;

public class Prob_1023 {
    public boolean queryString(String S, int N) {
        Set<Long>  numSet = new HashSet<>();

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 0; j <= S.length() - i; j++) {
                numSet.add(Long.valueOf(S.substring(j, j + i), 2));
            }
        }

        for (int i = 1; i <= N; i++) {
            if(!numSet.contains(Long.valueOf(i))) return false;
        }

        return true;

    }

    public static void main(String[] args) {
        Prob_1023 prob = new Prob_1023();
        AssertUtils.assertTrue(prob.queryString("0110", 3));
        AssertUtils.assertFalse(prob.queryString("0110", 4));
        AssertUtils.assertFalse(prob.queryString("0110", 4));

    }
}
