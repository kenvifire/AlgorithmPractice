package Leecode;

public class Prob_421 {
    public int findMaximumXOR(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if((nums[i] ^ nums[j]) > max) {
                    max = nums[i] ^ nums[j];
                }
            }
        }
        return max;

    }

    public static void main(String[] args) {
        Prob_421 prob = new Prob_421();
        prob.findMaximumXOR(new int[] {3,10,5,25,2,8});
    }
}
