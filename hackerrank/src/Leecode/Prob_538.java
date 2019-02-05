package Leecode;

import lib.TreeNode;

public class Prob_538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);

        return root;

    }
}
