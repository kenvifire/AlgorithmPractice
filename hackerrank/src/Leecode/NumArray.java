package Leecode;

import utils.AssertUtils;

public class NumArray {
    long sum[];
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        sum = new long[nums.length];
        long s = 0;
        for (int i = 0; i <nums.length; i++) {
            sum[i] = s;
            s += nums[i];
        }

    }

    public int sumRange(int i, int j) {
        return (int)(sum[j] - sum[i]) + nums[j];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-2, 0, 3, -5, 2, -1};
        NumArray prob = new NumArray(nums);
        AssertUtils.equals(1, prob.sumRange(0, 2));
        AssertUtils.equals(-1, prob.sumRange(2, 5));
        AssertUtils.equals(-3, prob.sumRange(0, 5));
    }
}
