package Leecode;

import utils.PrintUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Prob_384 {
    private int[] nums;
    public Prob_384(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        for (int i = nums.length; i > 1; i-- ) {
            int next = random.nextInt(i);

            int temp = result[i - 1];
            result[i - 1] = result[next];
            result[next] = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Prob_384 prob = new Prob_384(new int[] { 1, 2,3 ,4});
        for (int i = 0; i < 10; i ++) {
            PrintUtils.printArray(prob.shuffle());
        }
    }
}
