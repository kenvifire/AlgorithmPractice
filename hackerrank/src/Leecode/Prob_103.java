package Leecode;

import lib.TreeNode;
import utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Prob_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode>  queue = new ArrayDeque<>();

        List<List<Integer>> result = new ArrayList<>();
        boolean increase = true;
        queue.offer(root);
        while (!queue.isEmpty()) {

            int n = queue.size();

            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode top = queue.poll();
                current.add(top.val);
                if(top.left != null) queue.offer(top.left);
                if(top.right != null) queue.offer(top.right);
            }
            if(!increase) {
               List<Integer> temp = new ArrayList<>();
               for (int i = current.size() - 1; i >= 0; i--) temp.add(current.get(i));
               result.add(temp);
            } else {
                result.add(current);
            }
            increase = !increase;
        }
        return result;
    }

    public static void main(String[] args) {
        Prob_103 prob = new Prob_103();
        prob.zigzagLevelOrder(TreeUtils.fromString("[3,9,20,null,null,15,7]"));
    }
}
