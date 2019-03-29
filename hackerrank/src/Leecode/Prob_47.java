package Leecode;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Prob_47 {
    static class TrieNode {

        public TrieNode(int val) {
            this.val = val;
        }
        Map<Integer, TrieNode>  children = new HashMap<>();
        boolean isCompleted = false;
        int val;
    }

    TrieNode root;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> dupList = permute(nums, 0);
        List<List<Integer>> result = new ArrayList<>();

        root = new TrieNode(-1);
        for (List<Integer> list : dupList) {
            if(!exists(list)) {
                add(list);
                result.add(list);
            }
        }
        return result;



    }

    boolean exists(List<Integer> list) {
        TrieNode p = root;

        for (Integer e : list) {
            p = p.children.get(e);
            if(p == null) return false;
        }
        return p.isCompleted;

    }

    void add(List<Integer> list) {
        TrieNode p = root;
        for (Integer e : list) {
            p.children.putIfAbsent(e, new TrieNode(e));
            p = p.children.get(e);
        }
        p.isCompleted = true;
    }

    private List<List<Integer>> permute(int[] nums, int startPos) {
        List<List<Integer>> result = new ArrayList<>();

        if(startPos == nums.length) return new LinkedList<>();
        if(startPos == nums.length - 1) {
            result = new LinkedList<>();
            List<Integer> temp = new LinkedList<>();
            temp.add(nums[startPos]);
            result.add(temp);
            return result;
        }

        for (int i = startPos ; i < nums.length; i++) {
            swap(nums, startPos, i);
            List<List<Integer>> prevList = permute(nums, startPos + 1);
            swap(nums, i, startPos);
            for (List<Integer> prev : prevList) {
                prev.add(0, nums[i]);
            }
            result.addAll(prevList);

        }
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Prob_47 prob = new Prob_47();
        PrintUtils.printIntListList(prob.permuteUnique(new int[]{1,1,1 }));
    }
}
