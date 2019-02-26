package Leecode;

import lib.TreeNode;
import utils.AssertUtils;
import utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.Queue;

public class Prob_111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        int height = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            height ++;
            for (int i = 0; i < n; i ++) {
                TreeNode current = queue.poll();

                if(current.left == null && current.right == null) return height;

                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
        }

        return -1;

    }

    public int minDepth_v2(TreeNode root) {
       if(root == null)  return 0;

       if(root.left == null) return minDepth_v2(root.right) + 1;

       if(root.right == null) return minDepth_v2(root.left) + 1;

       return Math.min(minDepth_v2(root.left), minDepth_v2(root.right)) + 1;
    }

    public static void main(String[] args) {
        Prob_111 prob = new Prob_111();
        AssertUtils.equals(0, prob.minDepth(null));
        AssertUtils.equals(1, prob.minDepth(TreeUtils.fromString("[1]")));
        AssertUtils.equals(2, prob.minDepth(TreeUtils.fromString("[3,9,20,null,null,15,7]")));
        AssertUtils.equals(1, prob.minDepth(TreeUtils.fromString("[1,null,1,null,1,null]")));
        AssertUtils.equals(2, prob.minDepth(TreeUtils.fromString("[1,2]")));

    }
}
