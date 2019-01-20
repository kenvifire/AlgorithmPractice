package Leecode;

public class Prob_27 {
    public int removeElement(int[] nums, int val) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
           if(val != nums[i]) {
               nums[index++] = nums[i];
           }
        }

        return index;

    }
}
