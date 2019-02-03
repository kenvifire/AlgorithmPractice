package Leecode;

import lib.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Prob_653 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Map<Integer, Integer> cntMap = new HashMap<>();

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            cntMap.put(top.val, cntMap.getOrDefault(top.val, 0) + 1);

            if(top.left != null) {
                stack.push(top.left);
            }

            if(top.right != null) {
                stack.push(top.right);
            }
        }

        for (Integer val : cntMap.keySet()) {
            if(cntMap.containsKey(k - val)) {
                if(k-val != val){
                    return true;
                }else {
                    return cntMap.get(val) > 1;
                }

            }
        }
        return false;

    }
}
