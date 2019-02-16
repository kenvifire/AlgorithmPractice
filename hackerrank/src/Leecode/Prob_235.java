package Leecode;

import lib.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Prob_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        queue.offer(root);
        parentMap.put(root, null);


        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode top = queue.poll();

            if(top.left != null) {
                queue.offer(top.left);
                parentMap.put(top.left, top);
            }

            if(top.right != null) {
                queue.offer(top.right);
                parentMap.put(top.right, top);
            }

        }

        Set<TreeNode> pSet = new HashSet<>();

        while (p != null) {
            pSet.add(p);
            p = parentMap.get(p);
        }

        while (!pSet.contains(q)) {
            q = parentMap.get(q);
        }
        return q;

    }

}
