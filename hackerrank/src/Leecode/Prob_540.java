package Leecode;

public class Prob_540 {
    public int singleNonDuplicate(int[] nums) {
        int x = 0;
        for(int num : nums) {
            x ^= num;
        }
        return x;

    }
}
