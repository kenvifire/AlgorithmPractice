package Leecode;

import lib.TreeNode;

public class Prob_543 {
    int maxHeight = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        height(root);
        return maxHeight;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        int height = left + right;
        if(height > maxHeight) {
            maxHeight = height;
        }
        return 1 + (left > right ? left : right);
    }


}
