package Leecode;

import java.util.Arrays;

public class Prob_628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        if (nums[0] >= 0 || nums[len-1] < 0) return nums[len-1] * nums[len-2] * nums[len-3];


        int ngIdx = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] > 0) {
                ngIdx = i;
                break;
            }
        }

        int max = nums[len-1] * nums[len-2] * nums[len-3];;

        if(ngIdx > 2) {
            int ngMax = nums[0] * nums[1] * nums[len-1];
            if(ngMax > max) max = ngMax;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Prob_628().maximumProduct(new int[]{1,2,3}));
        System.out.println(new Prob_628().maximumProduct(new int[]{0, 1,2,3}));
        System.out.println(new Prob_628().maximumProduct(new int[]{-1, 0, 1,2,3}));
        System.out.println(new Prob_628().maximumProduct(new int[]{-1, -2, -4, -5}));
        System.out.println(new Prob_628().maximumProduct(new int[]{-1, -2, -4, -5, 5}));
        System.out.println(new Prob_628().maximumProduct(new int[]{-1, 2, 7, 6}));
    }
}
