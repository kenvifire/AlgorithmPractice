package Leecode;

import lib.TreeNode;

public class Prob_669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return trime(root, L, R);
    }

    private TreeNode trime(TreeNode root, int L, int R) {
        if(root == null) return null;
        if(root.val < L) {
            return trime(root.right, L, R);
        }else if(root.val > R) {
            return trime(root.left, L, R);
        } else {
            root.left = trime(root.left, L, R);
            root.right = trime(root.right, L, R);
            return root;
        }


    }
}
