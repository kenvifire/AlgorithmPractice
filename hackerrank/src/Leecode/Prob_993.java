package Leecode;

import lib.TreeNode;
import utils.AssertUtils;
import utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.Queue;

public class Prob_993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        int levelCnt = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();

            levelCnt = 0;
            for (int i = 0; i < n; i++) {
                TreeNode top = queue.poll();
                int nodeCnt = 0;

                if (top.left != null) {
                    queue.offer(top.left);
                    if (top.left.val == x || top.left.val == y) {
                        levelCnt++;
                        nodeCnt++;
                    }
                }

                if (top.right != null) {
                    queue.offer(top.right);
                    if (top.right.val == x || top.right.val == y) {
                        levelCnt++;
                        nodeCnt++;
                    }
                }


                if (nodeCnt >= 2) return false;

                if (levelCnt >= 2) return true;
            }


        }

        return false;

    }

    public static void main(String[] args) {
        Prob_993 prob = new Prob_993();
        AssertUtils.assertFalse(prob.isCousins(TreeUtils.fromString("[1,2,3,4]"), 4,3));
        AssertUtils.assertTrue(prob.isCousins(TreeUtils.fromString("[1,2,3,null,4,null,5]"), 5, 4));
        AssertUtils.assertFalse(prob.isCousins(TreeUtils.fromString("[1,2,3,null,4]"), 2, 3));
    }
}
