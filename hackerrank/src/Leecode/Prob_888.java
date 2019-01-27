package Leecode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Prob_888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();

        int avg = (sumA + sumB) / 2;

        int delta = sumA - avg;

        Set<Integer>  bSet = new HashSet<>();
        Arrays.stream(B).forEach(bSet::add);

        for (int a : A) {
            int target = a - delta;
            if(bSet.contains(target)) {
                return new int[] {a, target};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new Prob_888().fairCandySwap(new int[]{1,1}, new int[]{2,2});
    }
}
