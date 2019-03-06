package Leecode;

import lib.TreeNode;

public class Prob_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }

    private TreeNode construct(int[] nums, int start, int end) {
        if(start > end)  return null;
       if (start == end) return new TreeNode(nums[start]);

       int index = -1;
       int max = Integer.MIN_VALUE;
       for (int i = start; i <= end; i++) {
           if(nums[i] > max) {
               index = i;
               max = nums[i];
           }
       }
       TreeNode node = new TreeNode(nums[index]);
       node.left = construct(nums, start, index - 1);
       node.right = construct(nums, index + 1, end);

       return node;
    }



}
