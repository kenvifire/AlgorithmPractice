package Leecode;

import lib.TreeNode;

public class Prob_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) {
                return root.left.val + sumOfLeftLeaves(root.right);
            } else {
                return sumOfLeftLeaves(root.left)  + sumOfLeftLeaves(root.right);
            }
        } else {
            return sumOfLeftLeaves(root.right);
        }

    }
}
