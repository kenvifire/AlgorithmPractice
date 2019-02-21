package Leecode;

import lib.TreeNode;
import utils.PrintUtils;
import utils.TreeUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prob_501 {
    Set<Integer> modeSet = new HashSet<>();
    int max = 0;
    int cnt = 0;
    int currentValue = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        inOrder(root);

        int[] result = new int[modeSet.size()];
        int index = 0;
        for (int mode : modeSet) {
            result[index++] = mode;
        }
        return result;
    }

    private void inOrder(TreeNode root) {
        if(root == null) return;

        if(root.left != null) findMode(root.left);

        if(cnt == 0) {
            currentValue = root.val;
            cnt++;
        } else {
            if(root.val == currentValue) {
                cnt++;
            } else {
                currentValue = root.val;
                cnt = 1;
            }
        }

        if(cnt > max) {
            modeSet.clear();
            modeSet.add(currentValue);
            max = cnt;
        } else if(cnt == max) {
            modeSet.add(currentValue);
        }

        if(root.right != null) inOrder(root.right);

    }

    public static void main(String[] args) {
        Prob_501 prob = new Prob_501();
        PrintUtils.printArray(prob.findMode(TreeUtils.fromString("[1]")));
        prob = new Prob_501();
        PrintUtils.printArray(prob.findMode(TreeUtils.fromString("[1,1,2]")));
        prob = new Prob_501();
        PrintUtils.printArray(prob.findMode(TreeUtils.fromString("[1,1]")));
        prob = new Prob_501();
        PrintUtils.printArray(prob.findMode(TreeUtils.fromString("[1,null,2,2]")));
        prob = new Prob_501();
        PrintUtils.printArray(prob.findMode(TreeUtils.fromString("[1,null,2,2,3,null,null,3]")));
    }
}
