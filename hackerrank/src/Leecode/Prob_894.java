package Leecode;

import lib.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Prob_894 {
    Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if(!memo.containsKey(N)) {
            List<TreeNode> current = new LinkedList<>();
            if(N == 1) {
                current.add(new TreeNode(0));
            } else if(N % 2 == 1) {
                for (int left = 0; left < N; left++) {
                    int right = N - 1 - left;

                    for (TreeNode leftTree : allPossibleFBT(left)) {
                        for (TreeNode rightTree: allPossibleFBT(right)) {
                            TreeNode root = new TreeNode(0);
                            root.left = clone(leftTree);
                            root.right = clone(rightTree);
                            current.add(root);
                        }
                    }
                }
            }
            memo.put(N, current);

        }
        return memo.get(N);

    }





    private TreeNode clone(TreeNode root) {
        if(root == null) return null;
        TreeNode newTree = new TreeNode(root.val);
        newTree.left = clone(root.left);
        newTree.right = clone(root.right);
        return newTree;
    }

    public static void main(String[] args) {
        Prob_894 prob = new Prob_894();

        prob.allPossibleFBT(7);
    }
}
