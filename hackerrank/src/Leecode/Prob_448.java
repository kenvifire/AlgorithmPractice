package Leecode;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Prob_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        BitSet bs = new BitSet(nums.length);


        for (int i = 0; i < nums.length; i++) {
            bs.set(nums[i]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if(!bs.get(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PrintUtils.printIntList(new Prob_448().findDisappearedNumbers(new int[]{ 1, 2,2}));
        PrintUtils.printIntList(new Prob_448().findDisappearedNumbers(new int[]{ 1, 1}));
        PrintUtils.printIntList(new Prob_448().findDisappearedNumbers(new int[]{ 1, 3,3}));
        PrintUtils.printIntList(new Prob_448().findDisappearedNumbers(new int[]{ 1, 5,5, 4,4}));
    }
}
