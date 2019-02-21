package Leecode;

import utils.AssertUtils;

public class Prob_643 {
    public double findMaxAverage(int[] nums, int k) {
        long max = 0;
        long currSum = 0;

        for (int i = 0; i < k; i++) {
            max += nums[i];
            currSum += nums[i];
        }

        for (int i = k; i < nums.length; i++) {
            currSum -= nums [i - k];
            currSum += nums[i];
            if (currSum > max) max = currSum;
        }
        return (double)max/k;
    }

    public static void main(String[] args) {
        Prob_643 prob = new Prob_643();
        AssertUtils.equals(12.75, prob.findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4));
        AssertUtils.equals(50, prob.findMaxAverage(new int[] {1,12,-5,-6,50,3}, 1));
    }
}
