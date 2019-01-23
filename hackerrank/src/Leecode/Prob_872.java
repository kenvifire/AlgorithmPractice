package Leecode;

import lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Prob_872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1Leaf = new ArrayList<>();
        getLeafNodeValues(root1, tree1Leaf);

        List<Integer> tree2Leaf = new ArrayList<>();
        getLeafNodeValues(root2, tree2Leaf);

        if (tree1Leaf.size() != tree2Leaf.size()) return false;

        for (int i = 0; i < tree1Leaf.size(); i++) {
            if(tree1Leaf.get(i) != tree2Leaf.get(i)) return false;
        }
        return true;

    }

    public void getLeafNodeValues(TreeNode root, List<Integer> leafValues) {
        if(root == null) return;
        if (root.left == null && root.right == null) leafValues.add(root.val);

        if(root.left != null) {
            getLeafNodeValues(root.left, leafValues);
        }

        if(root.right != null) {
            getLeafNodeValues(root.right, leafValues);
        }

    }
}
