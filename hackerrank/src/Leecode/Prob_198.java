package Leecode;

public class Prob_198 {
    public int rob(int[] nums) {
        int eTotal = 0;
        int oTotal = 0;

        for (int i = 0; i < nums.length; i++) {
            if(i % 2 == 1) oTotal += nums[i];
            else eTotal += nums[i];
        }

        return eTotal > oTotal ? eTotal : oTotal;


    }
}
