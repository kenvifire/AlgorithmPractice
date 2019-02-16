package Leecode;

public class Prob_53 {
    public int maxSubArray(int[] nums) {
        int temp = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(temp > 0) {
                temp += nums[i] ;
            } else {
                temp = nums[i];
            }

            if(temp > max) max = temp;
        }

        return max;
    }

}
