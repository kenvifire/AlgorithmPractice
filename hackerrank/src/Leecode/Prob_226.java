package Leecode;

import lib.TreeNode;

public class Prob_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;


        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;


    }
}
