package Leecode;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currMax = nums[0];
        for(int i = 1; i < nums.length; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            max = Math.max(currMax, max);
        }

        return max;
    }

    public int maxSubArray_DP(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1] > 0 ? dp[i-1] + nums[i] : nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
