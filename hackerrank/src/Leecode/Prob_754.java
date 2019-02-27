package Leecode;

import utils.AssertUtils;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Prob_754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            target -= ++k;
        }

        return target % 2 == 0 ? k : k + 1 + k %2;

    }

    public static void main(String[] args) {
        Prob_754 prob = new Prob_754();
        AssertUtils.equals(3, prob.reachNumber(2));
        AssertUtils.equals(2, prob.reachNumber(3));
        AssertUtils.equals(44723, prob.reachNumber(-1000000000));
    }
}
