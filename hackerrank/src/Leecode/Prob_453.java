package Leecode;

import java.util.Arrays;

public class Prob_453 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int n : nums) {
            if(n < min) {
                min = n;
            }
            sum +=n;
        }

        return sum - min * nums.length;

    }

    public static void main(String[] args) {
        System.out.println(new Prob_453().minMoves(new int[] {1, 2, 3}));
        System.out.println(new Prob_453().minMoves(new int[] {3, 3, 3}));
        System.out.println(new Prob_453().minMoves(new int[] {3, 3}));
        System.out.println(new Prob_453().minMoves(new int[] {3}));
        System.out.println(new Prob_453().minMoves(new int[] {1, 3, 3}));
    }


}
