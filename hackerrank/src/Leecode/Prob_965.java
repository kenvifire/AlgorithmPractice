package Leecode;




public class Prob_965 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isUnivalTree(TreeNode root) {

        if (root == null) return true;
        int value = root.val;

        if(root.left != null && root.left.val != value) return false;
        if(root.right != null && root.right.val != value) return false;

        return isUnivalTree(root.left) && isUnivalTree(root.right);

    }


}
