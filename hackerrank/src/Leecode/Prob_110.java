package Leecode;

import lib.TreeNode;
import utils.AssertUtils;
import utils.TreeUtils;

public class Prob_110 {
    public boolean isBalanced(TreeNode root) {
        //FIXME todo
        return false;
    }



    public static void main(String[] args) {
        Prob_110 prb = new Prob_110();
        AssertUtils.assertTrue(prb.isBalanced(null));
        AssertUtils.assertTrue(prb.isBalanced(TreeUtils.fromIntArray(new Integer[] {1})));
        AssertUtils.assertTrue(prb.isBalanced(TreeUtils.fromIntArray(new Integer[] {1,2,3})));
        AssertUtils.assertTrue(prb.isBalanced(TreeUtils.fromIntArray(new Integer[] {1,2,3,4})));
        AssertUtils.assertFalse(prb.isBalanced(TreeUtils.fromString("1,2,2,3,3,null,null,4,4")));
        AssertUtils.assertTrue(prb.isBalanced(TreeUtils.fromString("3,9,20,null,null,15,7")));
        AssertUtils.assertFalse(prb.isBalanced(TreeUtils.fromString("1,null,2,null,3")));
        AssertUtils.assertTrue(prb.isBalanced(TreeUtils.fromString("[1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]")));
    }
}
