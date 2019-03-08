package Leecode;

import lib.TreeNode;
import utils.AssertUtils;
import utils.TreeUtils;

public class Prob_951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;


        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));

    }

    public static void main(String[] args) {
        Prob_951 prb = new Prob_951();
        AssertUtils.assertFalse(prb.flipEquiv(null, new TreeNode(1)));
        AssertUtils.assertTrue(prb.flipEquiv(TreeUtils.fromString("[1,2,3,4,5,6,null,null,null,7,8]"), TreeUtils.fromString("[1,3,2,null,6,4,5,null,null,null,null,8,7]")));
        AssertUtils.assertTrue(prb.flipEquiv(TreeUtils.fromString("[1,2,3]"), TreeUtils.fromString("[1,3,2]")));
    }
}
