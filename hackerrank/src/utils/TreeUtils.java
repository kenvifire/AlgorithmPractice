package utils;

import lib.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeUtils {
    private static TreeNode NULL_NODE = new TreeNode(-1);
    public static TreeNode fromIntArray(Integer[] arr) {
        if(arr == null) return null;
        int index = 0;
        TreeNode root = new TreeNode(arr[index]);
        index++;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if(current != null) {
                if(index < arr.length) {
                    current.left = (arr[index] == null) ? null: new TreeNode(arr[index]);
                    index++;
                }
                if(current.left != null) {
                    queue.offer(current.left);
                }

                if(index < arr.length) {
                    current.right = (arr[index] == null) ? null : new TreeNode(arr[index]);
                    index++;
                }
                if(current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return root;
    }

    public static TreeNode fromString(String string) {
        if(string.startsWith("[") && string.endsWith("]")) {
            string = string.substring(1, string.length() - 1);
        }

        List<Integer> values = new ArrayList<>();

        String[] arr = string.split(",");

        for (String ar: arr) {
            if(ar.equals("null")) {
                values.add(null);
            } else {
                values.add(Integer.valueOf(ar.trim()));
            }
        }
        Integer[] result = new Integer[values.size()];

        values.toArray(result);

        return fromIntArray(result);
    }

    public static String lelvelString(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            int n = stack.size();

            for (int i = 0; i < n; i++) {
                TreeNode curr = stack.pop();

                sb.append(curr == null ? "null" : curr.val);
                if (curr != null)  {
                   stack.push(curr.right);
                   stack.push(curr.left);
                }
            }
        }

        sb.append("]");
        return sb.toString();

    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.fromIntArray(new Integer[]{1});
        root = TreeUtils.fromIntArray(new Integer[]{1,2});
        root = TreeUtils.fromIntArray(new Integer[]{1,null,1,null,1,2});
    }


}
