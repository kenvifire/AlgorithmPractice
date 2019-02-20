package Leecode;


import lib.TreeNode;

public class Prob_965 {

    public boolean isUnivalTree(TreeNode root) {

        if (root == null) return true;
        int value = root.val;

        if(root.left != null && root.left.val != value) return false;
        if(root.right != null && root.right.val != value) return false;

        return isUnivalTree(root.left) && isUnivalTree(root.right);

    }


}
