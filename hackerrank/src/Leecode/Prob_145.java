package Leecode;

import apple.laf.JRSUIUtils;
import lib.TreeNode;
import utils.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Prob_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();

            //only when both leaves are visited:
            //both are null
            //prev is last non-null child
            if((top.left == null && top.right == null) || (prev != null && (prev == (top.right!= null ? top.right: top.left)))) {
                stack.pop();
                result.add(top.val);
                prev = top;
            } else {
                if(top.left != null) stack.push(top.left);
                if(top.right != null) stack.push(top.right);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node2;
        node2.left = node3;

        PrintUtils.printIntList(new Prob_145().postorderTraversal(root));


    }



}
