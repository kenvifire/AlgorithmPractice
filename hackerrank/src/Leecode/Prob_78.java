package Leecode;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class Prob_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            List<Integer> temp = new ArrayList<>();

            int n = i;
            int idx = 0;
            while (n > 0) {
                if((n & 0x01) == 1) {
                   temp.add(nums[idx]);
                }
                idx++;
                n >>= 1;
            }
            result.add(temp);
        }

        return result;

    }

    public static void main(String[] args) {
        Prob_78 prob = new Prob_78();
        PrintUtils.printIntListList(prob.subsets(new int[] {1,2,3}));
    }
}
