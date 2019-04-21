package Leecode;

import lib.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Prob_106 {

//    inorder = [9,3,15,20,7]
//    postorder = [9,15,7,20,3]
    Map<Integer, Integer>  inorderMap;
    int rootIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        rootIdx = inorder.length - 1;
        return build(inorder, 0, inorder.length - 1, postorder);

    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder) {
        if(inEnd < inStart || rootIdx >= inorder.length) return null;
        if(inStart == inEnd) return new TreeNode(inorder[inEnd]);

        int rootVal = postorder[rootIdx];
        TreeNode root = new TreeNode(rootVal);


        if (inorderMap.get(rootVal) >= inEnd) {
            root.right = null;
        } else {
            rootIdx--;
            root.right = build(inorder, inorderMap.get(rootVal) + 1,inEnd, postorder);
        }

        if (inorderMap.get(rootVal) <= inStart) {
            root.left = null;
        } else {
            rootIdx--;
            root.left = build(inorder, inStart, inorderMap.get(rootVal) - 1, postorder);
        }

        return root;
    }

    public static void main(String[] args) {
        System.out.println(new Prob_106().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
    }
}
