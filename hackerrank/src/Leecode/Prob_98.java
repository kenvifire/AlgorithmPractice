package Leecode;

import lib.TreeNode;
import utils.AssertUtils;
import utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class Prob_98 {
    List<Integer> numList;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        numList = new ArrayList<>();
        inOrder(root);

        for (int i = 0; i < numList.size() - 1; i++ ) {
            if(numList.get(i) >= numList.get(i + 1)) return false;
        }
        return true;
    }

    private void inOrder(TreeNode root) {
        if(root == null) return ;
        if(root.left != null) inOrder(root.left);
        numList.add(root.val);
        if(root.right != null) inOrder(root.right);
    }

    public static void main(String[] args) {
        Prob_98 prob = new Prob_98();
        AssertUtils.assertFalse(prob.isValidBST(TreeUtils.fromString("[1,1]")));
    }
}
