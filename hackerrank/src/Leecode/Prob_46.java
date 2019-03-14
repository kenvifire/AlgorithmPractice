package Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Prob_46 {
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }

    private List<List<Integer>> permute(int[] nums, int start) {
        List<List<Integer>> result = new LinkedList<>();
        if(start == nums.length - 1) {
            List<Integer> list = new LinkedList<>();
            list.add(nums[start]);
            result.add(list);
            return result;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            List<List<Integer>> tempList = permute(nums, start + 1);
            swap(nums, i, start);

            for (List<Integer> temp : tempList) {
                temp.add(0, nums[i]);
            }
            result.addAll(tempList);
        }
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
