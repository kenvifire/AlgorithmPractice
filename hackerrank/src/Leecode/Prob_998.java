package Leecode;

import lib.TreeNode;

public class Prob_998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if(val > root.val) {
            TreeNode curr = new TreeNode(val);
            curr.left= root;
            return curr;
        }

        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
