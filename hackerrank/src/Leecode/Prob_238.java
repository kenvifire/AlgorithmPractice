package Leecode;

public class Prob_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProd = new int[nums.length];
        int[] rightProd = new int[nums.length];

        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            leftProd[i] =  prod;
        }

        prod = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
           prod *= nums[j];
           rightProd[j] = prod;
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int left = (i == 0 ? 1 : leftProd[i-1]);
            int right = (i == nums.length - 1 ? 1 : rightProd[i+1]);

            result[i] = left * right;
        }

        return result;
    }
}
