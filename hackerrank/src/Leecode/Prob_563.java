package Leecode;

import lib.TreeNode;

public class Prob_563 {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        int left = findTilt(root.left);
        int right = findTilt(root.right);
        tilt += Math.abs(left - right);


        return root.val+ left + right;
    }

}
