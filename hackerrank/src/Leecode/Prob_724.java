package Leecode;

import utils.AssertUtils;

public class Prob_724 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int leftSum = 0;

        for (int i =0; i < nums.length; i++) {
           sum -= nums[i];
           if(leftSum == sum) {
               return i;
           }

           leftSum += nums[i];

        }

        return -1;
    }

    public static void main(String[] args) {
        Prob_724 prob = new Prob_724();
        AssertUtils.equals(-1, prob.pivotIndex(new int[]{}));
        AssertUtils.equals(0, prob.pivotIndex(new int[]{0}));
        AssertUtils.equals(-1, prob.pivotIndex(new int[]{1,2,3,4,5}));
        AssertUtils.equals(3, prob.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));

    }
}
