package Leecode;

import utils.AssertUtils;
import utils.PrintUtils;

public class Prob_80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        int current = nums[0];
        int dup = 0;
        int dupCnt = 1;
        for (int i = 1; i < nums.length; i++) {
           if(current == nums[i])  {
               dupCnt ++;
               if(dupCnt > 2) {
                   dup++;
               }
           } else {
               current = nums[i];
               dupCnt = 1;
           }
            nums[i - dup] = nums[i];
            PrintUtils.printArray(nums);

        }
        return nums.length - dup;
    }

    public static void main(String[] args) {
        Prob_80 prob = new Prob_80();
        int[] array = new int[] {1,1,1};
        AssertUtils.equals(2, prob.removeDuplicates(array));
        PrintUtils.printArray(array);
    }
}
