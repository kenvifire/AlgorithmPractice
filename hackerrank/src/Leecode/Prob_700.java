package Leecode;

import lib.TreeNode;

public class Prob_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode p = root;
        while (p != null) {
            if(p.val == val) return p;
            if(val < p.val) p = p.left;
            else p = p.right;
        }
        return null;


    }
}
