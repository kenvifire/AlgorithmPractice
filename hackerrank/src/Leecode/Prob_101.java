package Leecode;

import lib.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Prob_101 {
    private TreeNode NULL_NODE = new TreeNode(-1);
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);
        List<TreeNode> currentList  = new ArrayList<>();
        while (!queue.isEmpty()) {
            int n  = queue.size();
            currentList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                currentList.add(node);

                if(node != NULL_NODE) {
                    queue.add(node.left == null ? NULL_NODE : node.left);
                    queue.add(node.right == null ? NULL_NODE : node.right);
                }
            }
            if(!isSymmetric(currentList))  return false;



        }

        return isSymmetric(currentList);


    }

    private boolean isSymmetric(List<TreeNode> treeNodeList) {

        int left = 0, right = treeNodeList.size() - 1;
        while (left <= right) {
            TreeNode leftNode = treeNodeList.get(left);
            TreeNode rightNode = treeNodeList.get(right);

            if((leftNode == null && rightNode != null)
                    || (leftNode != null && rightNode == null)
                    || (leftNode.val != rightNode.val)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node.left = node2;
        node.right = node3;

        System.out.println(new Prob_101().isSymmetric(node));

    }

}
