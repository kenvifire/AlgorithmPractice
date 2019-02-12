package Leecode;

import lib.TreeNode;
import utils.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob_257 {
    List<List<Integer>> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> rootList = new ArrayList<>();
        dfs(root, rootList);

        List<String> strList = new ArrayList<>();
        for (List<Integer> list : result) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < list.size() - 1; i++) {
                sb.append(String.valueOf(list.get(i))).append("->");
            }
            sb.append(String.valueOf(list.get(list.size() - 1)));
            strList.add(sb.toString());
        }
        return strList;

    }

    private void dfs(TreeNode root, List<Integer> currentList) {
        if(root==null) return;
        if(root.left == null && root.right == null){
            currentList.add(root.val);
            result.add(currentList);
            return;
        }


        if(root.left != null) {

            List<Integer> list = new ArrayList<>(currentList);
            list.add(root.val);
            dfs(root.left, list);

        }
        if(root.right != null) {

            List<Integer> list = new ArrayList<>(currentList);
            list.add(root.val);
            dfs(root.right, list);
        }
    }

    public static void main(String[] args) {
        Prob_257 prob = new Prob_257();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        node2.right = node5;
        node2.left = node4;

        PrintUtils.printStringList(prob.binaryTreePaths(root));
    }
}
