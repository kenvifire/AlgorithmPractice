package Leecode;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Prob_442 {
    public List<Integer> findDuplicates(int[] nums) {
        BitSet bitSet = new BitSet(nums.length);
        List<Integer> dupList= new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(bitSet.get(nums[i])) {
                dupList.add(nums[i]);
            } else {
                bitSet.set(nums[i]);
            }
        }
        return dupList;

    }
}
