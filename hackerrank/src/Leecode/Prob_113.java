package Leecode;

import lib.TreeNode;
import utils.PrintUtils;
import utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class Prob_113 {

    List<List<Integer>> pathList;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathList = new ArrayList<>();
        pathSum(root, new ArrayList<>(), sum);
        return pathList;
    }

    public void pathSum(TreeNode root, List<Integer> currentList, int left) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(root.val == left) {
                pathList.add(currentList);
            } else {
                return;
            }

        }
        List<Integer> copy = new ArrayList<>();
        copy.addAll(currentList);
        currentList.add(root.val);
        pathSum(root.left, currentList, left - root.val);

        copy.add(root.val);
        pathSum(root.right, copy, left - root.val);
    }

    public static void main(String[] args) {
        Prob_113 prob = new Prob_113();
        PrintUtils.printIntListList(prob.pathSum(TreeUtils.fromString("[5,4,8,11,null,13,4,7,2,null,null,5,1]"), 22));
    }
}
