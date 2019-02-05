package Leecode;

import lib.TreeNode;

import java.util.Stack;

public class Prob_783 {
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {

        Stack<TreeNode>  stack = new Stack<>();

        stack.push(root);

        TreeNode curr = root;
        TreeNode prev = null;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if(prev != null && prev != curr)  {
                int dist = Math.abs(prev.val - curr.val);

                if(dist < min) {
                    min = dist;
                }
            }

            prev = curr;

            curr = curr.right;

        }
        return min;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;

        System.out.println(new Prob_783().minDiffInBST(root));
    }


}
