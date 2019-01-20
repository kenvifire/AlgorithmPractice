package Leecode;

public class Prob_26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        int curr = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
           if(curr != nums[i]) {
               nums[index++] = nums[i];
               curr = nums[i];
           }
        }

        return index;

    }
}
