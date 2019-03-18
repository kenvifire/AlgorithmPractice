package Leecode;

import com.sun.source.tree.AssertTree;
import lib.TreeNode;
import utils.AssertUtils;
import utils.PrintUtils;
import utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Prob_655 {
    public List<List<String>> printTree(TreeNode root) {
        return getString(root);
    }

    private List<List<String>> getString(TreeNode root) {
        if(root == null) return new ArrayList<>();
        if(root.left == null && root.right == null) {
            List<List<String>> result = new ArrayList<>();
            List<String> rootList = new ArrayList<>();
            rootList.add(String.valueOf(root.val));
            result.add(rootList);
            return result;
        }

        List<List<String>> leftList = getString(root.left);
        List<List<String>> rightList  = getString(root.right);

        int row = Math.max(leftList.size(), rightList.size());
        int col = Math.max(leftList.size() == 0 ? 0 : leftList.get(0).size(),
                rightList.size() == 0 ? 0 : rightList.get(0).size());
        leftList = fillToSize(leftList, row, col);
        rightList = fillToSize(rightList, row, col);

        for (int i = 0; i < leftList.size(); i++) {
            leftList.get(i).add("");
            leftList.get(i).addAll(rightList.get(i));
        }

        List<String> firstRow = new ArrayList<>();
        for (int i = 0; i < leftList.get(0).size(); i++) {
            if(i == leftList.get(0).size() / 2) {
                firstRow.add(String.valueOf(root.val));
            } else {
                firstRow.add("");
            }
        }

        List<List<String>> result = new ArrayList<>();
        result.add(firstRow);
        result.addAll(leftList);
        return result;
    }
    private List<List<String>>  fillToSize(List<List<String>> origin, int row, int column) {
        if(origin.size() >= row && origin.get(0).size() == column) return origin;

        List<List<String>> result = new ArrayList<>();


        for (int i = 0; i < row; i++) {
            List<String> temp = new ArrayList<>();
            if(i < origin.size()) {
                //left
                int j = 0;
                while (j < column - origin.size() - 1) {
                    temp.add("");
                    j++;
                }
                temp.addAll(origin.get(i));
                j = 0;
                while (j < column - origin.size() - 1) {
                    temp.add("");
                    j++;
                }

            }else {
                for (int j = 0; j < column; j++) {
                    temp.add("");
                }
            }
            result.add(temp);
        }
        return result;
    }
}
