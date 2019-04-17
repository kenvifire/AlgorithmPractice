package Leecode;

import lib.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Prob_105 {
    Map<Integer, Integer> inorderMap;
    int rootIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        inorderMap = new HashMap<>();
        int n = preorder.length;

        for (int i = 0; i < n; i ++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder,  inorder, 0, n - 1);
    }

//    preorder = [3,9,20,15,7]
//    inorder =  [9,3,15,20,7]
    private TreeNode build(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if(rootIdx >= preorder.length) return null;
        if(inStart == inEnd) return new TreeNode(preorder[rootIdx]);

        int rootVal = preorder[rootIdx];
        TreeNode root = new TreeNode(rootVal);

        if(inorderMap.get(rootVal) <= inStart)  {
            root.left = null;
        } else {
            rootIdx++;
            root.left = build(preorder,  inorder, inStart, inorderMap.get(rootVal) - 1);
        }

        if(inorderMap.get(rootVal) >= inEnd) {
            root.right = null;
        } else {
            rootIdx++;
            root.right = build(preorder, inorder, inorderMap.get(rootVal) + 1, inEnd);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new Prob_105().buildTree(new int [] {7,-10,-4,3,-1,2,-8,11}, new int[] {-4,-10,3,-1,7,11,-8,2});
        System.out.println(tree.toString());
    }
}
