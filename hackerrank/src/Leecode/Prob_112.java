package Leecode;

import lib.TreeNode;

public class Prob_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        return hasPathSum0(root, sum);

    }

    private boolean hasPathSum0(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) {
            if(sum == root.val) {
                return true;
            }else {
                return false;
            }
        }

        return hasPathSum0(root.left, sum - root.val) || hasPathSum0(root.right, sum - root.val);
    }


}
