package Leecode;

import lib.TreeNode;

public class Prob_617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
      TreeNode t3 = null;

      if(t1 != null && t2 != null)  {
        t3 = new TreeNode(t1.val + t2.val);
      } else if(t1 != null) {
        t3 = new TreeNode(t1.val);
      } else if(t2 != null) {
        t3 = new TreeNode(t2.val);
      }

      t3.left = mergeTrees(t1.left, t2.left);
      t3.right = mergeTrees(t1.right, t2.right);

      return t3;

    }
}
