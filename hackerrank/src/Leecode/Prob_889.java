package Leecode;

import lib.TreeNode;
import utils.AssertUtils;
import utils.TreeUtils;

import java.util.HashMap;
import java.util.Map;

public class Prob_889 {
    Map<Integer, Integer> preMap;
    Map<Integer, Integer> postMap;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        preMap = new HashMap<>();
        postMap = new HashMap<>();

        for (int i = 0; i < pre.length; i++) {
            preMap.put(pre[i], i);
            postMap.put(post[i], i);
        }


        return construct(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode construct(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        System.out.println(String.format("(%d,%d) - (%d,%d)", preStart, preEnd, postStart, postEnd));
        if(preStart > preEnd) return null;
        if(preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }

        int leftRoot = pre[preStart + 1];
        int rightRoot = post[postEnd - 1];


        TreeNode left = construct(pre, preStart + 1, preMap.get(rightRoot) - 1, post, postStart, postMap.get(leftRoot)) ;
        TreeNode right = construct(pre, preMap.get(rightRoot), preEnd , post, postMap.get(leftRoot) + 1,postEnd - 1);

        TreeNode root = new TreeNode(pre[preStart]);

        root.left = left;
        root.right = right;

        return root;

    }

    public static void main(String[] args) {
        Prob_889 prob = new Prob_889();
        TreeNode root = prob.constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1});
    }
}
