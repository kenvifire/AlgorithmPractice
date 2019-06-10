package Leecode;

import lib.TreeNode;
import utils.TreeUtils;

public class Prob_114 {
    public void flatten(TreeNode root) {
        flattenNode(root);
    }

    private TreeNode flattenNode(TreeNode root) {
        if(root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(root.left != null) {
            left = flattenNode(root.left);
        }

        if(root.right != null) {
            right = flattenNode(root.right);
        }

        if(left != null) {
            root.left = null;
            root.right = left;
            TreeNode p = left;
            while (p.right != null) {
                p = p.right;
            }
            p.right = right;
        } else {
            root.right = right;
        }

        return root;

    }

    public static void main(String[] args) {
        Prob_114 prob = new Prob_114();
        TreeNode tree = TreeUtils.fromString("[1,2,3]");
        prob.flattenNode(tree);
        System.out.println(tree.toString());
    }


}
