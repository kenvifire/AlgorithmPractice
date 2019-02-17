package Leecode;

import java.util.BitSet;

public class Prob_645 {
    public int[] findErrorNums(int[] nums) {
        BitSet bs = new BitSet(nums.length);

        int[] result = new int[2];
        for (int num : nums) {
            if(bs.get(num - 1)) {
                result[0] = num;
            } else {
                bs.set(num - 1);
            }
        }

        for (int i = 0; i < nums.length; i++ ) {
            if(!bs.get(i)) {
                result[1] = i;
            }
        }

        return result;
    }
}
