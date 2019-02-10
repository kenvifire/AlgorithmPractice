package Leecode;

import lib.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Prob_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return Collections.emptyList();

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        List<List<Integer>> resultList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int n = queue.size();

            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode top = queue.poll();
                current.add(top.val);
                if (top.left != null) queue.offer(top.left);
                if (top.right != null) queue.offer(top.right);
            }
            resultList.add(current);
        }
        Collections.reverse(resultList);
        return resultList;
    }
}
