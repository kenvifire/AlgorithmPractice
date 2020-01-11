package Leecode;

import lib.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class AllNodesDistanceKinBinaryTree {


    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, Integer> distanceToRoot = new HashMap<>();
        Map<TreeNode, Integer> distanceToTarget = new HashMap<>();

        calculateDistance(root, 0, distanceToRoot);
        calculateDistance(target, 0, distanceToTarget);

        List<Integer> result = new ArrayList<>();
        //direct distance
        for (Map.Entry<TreeNode, Integer> entry: distanceToTarget.entrySet()) {
            if(entry.getValue() == K) {
                result.add(entry.getKey().val);
            }
        }
        int rootToTarget = distanceToRoot.get(target);

        if(rootToTarget == K) {
            result.add(root.val);
        } else if (rootToTarget < K) {

        }


        return null;

    }

    public void calculateDistance(TreeNode root, int distance, Map<TreeNode, Integer> result) {
        if(root == null) return;
        result.put(root, distance);

        calculateDistance(root.left, distance + 1, result);
        calculateDistance(root.right, distance + 1, result);
    }


}
