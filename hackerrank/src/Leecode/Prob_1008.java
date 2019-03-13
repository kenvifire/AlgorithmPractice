package Leecode;

import lib.TreeNode;

public class Prob_1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }

    private TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if(start > end) return null;
        if(start == end) return new TreeNode(preorder[start]);
        if(start + 1 == end) {
            TreeNode root = new TreeNode(preorder[start]);
            if(preorder[end] > root.val) {
                root.right = new TreeNode(preorder[end]);
            } else {
                root.left = new TreeNode(preorder[end]);
            }
            return root;
        }

        int rootVal = preorder[start];

        int spiltIdx = start + 1;

        while (spiltIdx <= end && preorder[spiltIdx] < rootVal) spiltIdx++;

        TreeNode root = new TreeNode(rootVal);
        root.left = bstFromPreorder(preorder, start + 1, spiltIdx - 1);
        root.right = bstFromPreorder(preorder, spiltIdx, end);

        return root;
    }

    public static void main(String[] args) {
        Prob_1008 prob = new Prob_1008();
        prob.bstFromPreorder(new int[] {10, 12});

    }
}
