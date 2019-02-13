package Leecode;

import java.util.HashSet;
import java.util.Set;

public class Prob_202 {
    public boolean isHappy(int n) {
        Set<Integer>  numSet = new HashSet<>();

        int current = n;
        while (!numSet.contains(current)) {
            numSet.add(current);

            int total = 0;

            while (current > 0) {
                total += (current % 10) * (current % 10);
                current /= 10;
            }
            if (total == 1) return true;
            current = total;
        }
        return false;

    }

    public static void main(String[] args) {
        Prob_202 prob = new Prob_202();
        prob.isHappy(19);
    }




}
