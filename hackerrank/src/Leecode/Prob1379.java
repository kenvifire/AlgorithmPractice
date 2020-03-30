package Leecode;

import lib.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 */
public class Prob1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        Stack<TreeNode> stack = new Stack<>();

        stack.push(cloned);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if(curr.val == target.val) return curr;

            if(curr.left != null) stack.push(curr.left);
            if(curr.right != null) stack.push(curr.right);
        }

        return null;


    }


}
