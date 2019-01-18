package Leecode;




import utils.AssertUtils;

import java.util.Arrays;

public class Prob_16 {


    public int threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        // 1 2 3 4 5
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int b = nums[left], c = nums[right];

                if (Math.abs(target - result) > Math.abs(target - a - b - c)) {
                    result = a + b + c;
                }

                if ((a + b + c) < target) {
                    left++;
                } else if ((a + b + c) > target) {
                    right --;
                } else {
                    return target;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        AssertUtils.equals(new Prob_16().threeSum(new int[] { -1, 2, 1, -4}, 1), 2);
        AssertUtils.equals(new Prob_16().threeSum(new int[] { -1, 2, 1}, 1), 2);
        AssertUtils.equals(new Prob_16().threeSum(new int[] { -1, 2, 1, 0}, 0), 0);
        AssertUtils.equals(new Prob_16().threeSum(new int[] {1,2,4,8,16,32,64,128}, 82), 82);
    }
}
