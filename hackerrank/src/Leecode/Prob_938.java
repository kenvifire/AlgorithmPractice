package Leecode;

import lib.TreeNode;

public class Prob_938 {
    private int total = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        rangeSum(root, L, R);
        return total;
    }

    private void rangeSum(TreeNode root, int L, int R) {
        if(root == null) return;
        if(root.val >= L && root.val <= R) total += root.val;

        rangeSumBST(root.left, L, R);
        rangeSumBST(root.right, L, R);
    }

    public static void main(String[] args) {

    }
}
