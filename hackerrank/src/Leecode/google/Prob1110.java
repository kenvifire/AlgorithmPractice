package Leecode.google;

import lib.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Prob1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> forest = new ArrayList<>();
        forest.add(root);

        Set<Integer> rootToDelete = new HashSet<>();

        for (int node : to_delete) {
            for (TreeNode tree : forest) {
                if (tree.val == node) {
                    rootToDelete.add(node);
                }
                List<TreeNode> trees = del(null, true, tree, node);
                if (!trees.isEmpty()) {
                    for (TreeNode newTree : trees) {
                        if (newTree != null) {
                            forest.add(newTree);
                        }
                    }
                    break;
                }
            }
        }

        List<TreeNode> result = new ArrayList<>();
        for (TreeNode f : forest) {
            if (!rootToDelete.contains(f.val)) {
                result.add(f);
            }
        }

        return result;

    }

    private List<TreeNode> del(TreeNode parent, boolean isLeft, TreeNode curr, int val) {
        if (curr == null) return new ArrayList<>();

        if (curr.val == val) {
            if (parent != null) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            List<TreeNode> result = new ArrayList<TreeNode>();
            result.add(curr.left);
            result.add(curr.right);

            curr.left = null;
            curr.right = null;
            return result;
        } else {
            List<TreeNode> leftResult = del(curr, true, curr.left, val);
            if (leftResult.isEmpty()) {

                return del(curr, false, curr.right, val);
            } else {
                return leftResult;
            }
        }

    }

    public List<TreeNode> delNodes2(TreeNode root, int[] to_delete) {
        Map<Integer, TreeNode> treeMap = new HashMap<>();
        Map<Integer, TreeNode> parentMap = new HashMap<>();
        buildMap(null, root, treeMap, parentMap);

        List<TreeNode> forest = new ArrayList<>();

        Set<Integer> nodeSet = new HashSet<>();
        Arrays.stream(to_delete).forEach(
            del -> {
                TreeNode nodeToDel = treeMap.get(del);
                if(nodeToDel.left != null) forest.add(nodeToDel.left);
                if(nodeToDel.right != null) forest.add(nodeToDel.right);
                nodeToDel.left = null;
                nodeToDel.right = null;

                TreeNode parent = parentMap.get(nodeToDel.val);
                if(parent != null) {
                    if(parent.left == nodeToDel) parent.left = null;
                    else if(parent.right == nodeToDel) parent.right = null;
                }

                nodeSet.add(del);
            }
        );

        return forest.stream().filter(t -> !nodeSet.contains(t.val)).collect(Collectors.toList());

    }

    private void buildMap(TreeNode parent, TreeNode curr, Map<Integer, TreeNode> treeMap, Map<Integer, TreeNode> parentMap) {
        if(curr == null) return;
        parentMap.put(curr.val, parent);
        treeMap.put(curr.val, curr);
        if(curr.left != null) buildMap(curr, curr.left, treeMap, parentMap);
        if(curr.right != null) buildMap(curr, curr.right, treeMap, parentMap);
    }


}
