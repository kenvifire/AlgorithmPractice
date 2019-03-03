package Leecode;

public class Prob_665 {
    public boolean checkPossibility(int[] nums) {
        if(nums.length <= 1) return true;

        int cnt = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i+1]) {
                cnt++;
                nums[i+1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}
