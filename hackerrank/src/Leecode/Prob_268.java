package Leecode;

import java.util.BitSet;

public class Prob_268 {
    public int missingNumber(int[] nums) {
        BitSet bs = new BitSet(nums.length + 1);

        for (int i = 0; i < nums.length; i++) {
            bs.set(nums[i]);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!bs.get(i)) return i;
        }
        return nums.length;

    }

}
