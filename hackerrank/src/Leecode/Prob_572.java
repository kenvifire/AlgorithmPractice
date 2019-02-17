package Leecode;

import lib.TreeNode;
import utils.TreeUtils;

public class Prob_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null ) return true;
        if(s == null) return false;

        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);


    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;

        if(s == null || t == null)  {
            return false;
        }

        if(s.val == t.val) return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);

        return false;
    }

    public static void main(String[] args) {
        TreeNode s = TreeUtils.fromIntArray(new Integer[]{1,null,1,null,1,2});
        TreeNode t = TreeUtils.fromIntArray(new Integer[]{1,2});

        Prob_572 prob = new Prob_572();
        prob.isSubtree(s, t);


    }
}
