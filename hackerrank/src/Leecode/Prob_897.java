package Leecode;

import lib.TreeNode;

public class Prob_897 {
    private TreeNode result;
    private TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        inOrderReverse(root);
        return result;
    }

    private void attachNode(TreeNode node) {
        if (result == null) {
            result  = node;
            curr = node;
            node.left = null;
        } else {
            curr.right = node;
            curr = curr.right;
            node.left = null;
        }
    }

    private void inOrderReverse(TreeNode root) {
        if(root == null) return;


        if(root.left != null) {
            inOrderReverse(root.left);
        }

        attachNode(root);

        if(root.right != null) {
            inOrderReverse(root.right);
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        new Prob_897().increasingBST(root);
    }
}
