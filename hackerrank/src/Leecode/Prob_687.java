package Leecode;

import lib.TreeNode;

public class Prob_687 {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        longestPath(root);
        return max;
    }

    private int longestPath(TreeNode root) {
        if(root == null) return 0;

        int left = longestPath(root.left);
        int right = longestPath(root.right);

        int leftLen = 0, rightLen = 0;
        if(root.left != null && root.val == root.left.val) {
            leftLen = 1 + left;
        }

        if(root.right != null && root.val == root.right.val) {
            rightLen = right + 1;
        }

        max = Math.max(max, leftLen + rightLen);

        return Math.max(leftLen, rightLen);
    }

}
