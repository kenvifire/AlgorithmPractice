package Leecode;

import lib.TreeNode;
import utils.AssertUtils;
import utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Prob_110 {

    Map<TreeNode, Integer> heightMap = new HashMap<>();

    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }


    private int height(TreeNode root) {
        if (root == null) return 0;

        int left = 0;
        int right = 0;

        if(root.left != null) left = height(root.left);
        if(root.right != null) right = height(root.right);

        return Math.max(left, right) + 1;

    }




    public static void main(String[] args) {
        Prob_110 prb = new Prob_110();
        AssertUtils.assertTrue(prb.isBalanced(null));
        AssertUtils.assertTrue(prb.isBalanced(TreeUtils.fromIntArray(new Integer[] {1})));
        AssertUtils.assertTrue(prb.isBalanced(TreeUtils.fromIntArray(new Integer[] {1,2,3})));
        AssertUtils.assertTrue(prb.isBalanced(TreeUtils.fromIntArray(new Integer[] {1,2,3,4})));
        AssertUtils.assertFalse(prb.isBalanced(TreeUtils.fromString("1,2,2,3,3,null,null,4,4")));
        AssertUtils.assertTrue(prb.isBalanced(TreeUtils.fromString("3,9,20,null,null,15,7")));
        AssertUtils.assertFalse(prb.isBalanced(TreeUtils.fromString("1,null,2,null,3")));
        AssertUtils.assertTrue(prb.isBalanced(TreeUtils.fromString("[1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]")));
    }
}
