package Leecode;

import lib.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 */
public class Prob1161 {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        int maxLevel = 1;
        int max = Integer.MIN_VALUE;

        queue.add(root);
        int level = 1;

        while(!queue.isEmpty()) {
            int n = queue.size();

            int sum = 0;
            for(int i = 0; i < n; i++ ) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            if(sum > max) {
                max = sum;
                maxLevel = level;
            }
            level++;
        }

        return maxLevel;


    }
}
