package Leecode;

import lib.TreeNode;

public class Prob_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root, val);
    }

    private TreeNode insert(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }

        if(val < root.val)
            root.left = insert(root.left, val);
        if(val > root.val)
            root.right = insert(root.right, val);
        return root;
    }



}
