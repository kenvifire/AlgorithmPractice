package Leecode;

import lib.TreeNode;
import utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Prob_513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        TreeNode leftMost = root;
        while (!queue.isEmpty()) {
           int n = queue.size();

           for (int i = 0; i < n; i++) {
               TreeNode top = queue.poll();

               if(i==0) {
                   leftMost = top;
               }

               if(top.left != null) queue.offer(top.left);
               if(top.right != null) queue.offer(top.right);
           }
        }

        return leftMost.val;

    }

    public static void main(String[] args) {
        Prob_513 prob = new Prob_513();
        prob.findBottomLeftValue(TreeUtils.fromString("[2,1,3]"));
    }
}
