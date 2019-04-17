package Leecode;

import lib.TreeNode;
import utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class Prob_95 {

    public List<TreeNode> generateTrees(int n) {
        if(n <= 0) return new ArrayList<>();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = i + 1;

        return generate(array, 0, array.length - 1);

    }

    public List<TreeNode> generate(int[] array, int start, int end) {
        if(start > end)  {
            List<TreeNode> nodeList = new ArrayList<>();
            nodeList.add(null);
            return nodeList;
        }

        if(start == end) {
            List<TreeNode> nodeList = new ArrayList<>();
            nodeList.add(new TreeNode(array[start]));
            return nodeList;
        }

        List<TreeNode> resultList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = generate(array, start, i - 1);
            List<TreeNode> rightList = generate(array, i + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(array[i]);
                    root.left = left;
                    root.right = right;
                    resultList.add(root);
                }
            }
        }

        return resultList;

    }

    public static void main(String[] args) {
        Prob_95 prob = new Prob_95();
        List<TreeNode> result;
//        result = prob.generateTrees(0);
//        result.forEach(e -> System.out.println(e.toString()));
//        result = prob.generateTrees(1);
//        result.forEach(e -> System.out.println(e.toString()));
        result = prob.generateTrees(3);
        result.forEach(e -> System.out.println(e.toString()));
    }

}
