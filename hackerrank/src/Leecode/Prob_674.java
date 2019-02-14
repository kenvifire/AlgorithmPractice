package Leecode;

public class Prob_674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length <= 1) return nums.length;

        int len = 1;
        int current = nums[0];
        int max = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > current) {
                len ++;
                if(len > max) {
                    max = len;
                }

            } else {
                len = 1;
            }
            current = nums[i];
        }

        if(len > max) max = len;
        return max;
    }

    public static void main(String[] args) {
        Prob_674 prob = new Prob_674();

        System.out.println(prob.findLengthOfLCIS(new int[]{}));
        System.out.println(prob.findLengthOfLCIS(new int[]{1}));
        System.out.println(prob.findLengthOfLCIS(new int[]{1,1}));
        System.out.println(prob.findLengthOfLCIS(new int[]{1,1,2}));
        System.out.println(prob.findLengthOfLCIS(new int[]{1,1,2,2}));
        System.out.println(prob.findLengthOfLCIS(new int[]{1,1,2,2,3}));
        System.out.println(prob.findLengthOfLCIS(new int[]{1,1,2,2,3,4,0,1,2,3,4}));
    }
}
