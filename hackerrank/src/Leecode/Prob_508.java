package Leecode;

import lib.TreeNode;
import utils.AssertUtils;
import utils.PrintUtils;
import utils.TreeUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prob_508 {
    Map<TreeNode, Integer> sumMap;
    Map<Integer, Integer> cntMap;

    public int[] findFrequentTreeSum(TreeNode root) {
        sumMap = new HashMap<>();
        cntMap = new HashMap<>();

        sum(root);

        int maxCnt = Integer.MIN_VALUE;
        Set<Integer> maxValueSet = new HashSet<>();

        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if(entry.getValue() > maxCnt) {
                maxValueSet.clear();
                maxCnt = entry.getValue();
                maxValueSet.add(entry.getKey());
            } else if(entry.getValue() == maxCnt) {
                maxValueSet.add(entry.getKey());
            }
        }

        int[] result = new int[maxValueSet.size()];
        int idx = 0;
        for (int val : maxValueSet) result[idx++] = val;
        return result;
    }

    private int sum(TreeNode root) {
        if(root == null) return 0 ;

        if(sumMap.get(root) != null) {
            return sumMap.get(root);
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        int rootSum = leftSum + rightSum + root.val;

        int val = cntMap.getOrDefault(rootSum, 0);
        cntMap.put(rootSum, val + 1);
        sumMap.put(root, rootSum);


        return rootSum;

    }

    public static void main(String[] args) {
        Prob_508 prob = new Prob_508();
        PrintUtils.printArray(prob.findFrequentTreeSum(TreeUtils.fromString("[5,2,-3]")));
        PrintUtils.printArray(prob.findFrequentTreeSum(TreeUtils.fromString("[5,2,-5]")));
    }


}
