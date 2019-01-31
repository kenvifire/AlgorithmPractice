package Leecode;

import utils.PrintUtils;

public class Prob_283 {
    public void moveZeroes(int[] nums) {


        int zeroCnt = 0;

        int i = 0;

        while (i < nums.length) {
            if(nums[i] == 0) {
                zeroCnt ++;
            } else {
                if (zeroCnt > 0) {
                    nums[i - zeroCnt] = nums[i];
                    nums[i] = 0;
                }
            }

            i++;

        }

    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};
        new Prob_283().moveZeroes(arr);
        PrintUtils.printArray(arr);
        arr = new int[] { 0, 1, 2};
        new Prob_283().moveZeroes(arr);
        PrintUtils.printArray(arr);
        arr = new int[] { 0, 1,0, 2,3, 0};
        new Prob_283().moveZeroes(arr);
        PrintUtils.printArray(arr);
    }
}
