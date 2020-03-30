package Leecode.contest169;

import lib.TreeNode;
import utils.PrintUtils;
import utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
    private List<Integer> treeNodeList;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        treeNodeList = new ArrayList<>();
        visit(root1);
        List<Integer> root1NodeList = treeNodeList;

        treeNodeList = new ArrayList<>();
        visit(root2);
        List<Integer> root2NodeList = treeNodeList;

        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0;
        for (; i < root1NodeList.size() || j < root2NodeList.size(); ) {
            if(i < root1NodeList.size() && j < root2NodeList.size()) {
                if(root1NodeList.get(i) < root2NodeList.get(j)) {
                    result.add(root1NodeList.get(i));
                    i++;
                } else {
                    result.add(root2NodeList.get(j));
                    j++;
                }
            } else if(i < root1NodeList.size()) {
                result.add(root1NodeList.get(i));
                i++;
            } else {
                result.add(root2NodeList.get(j));
                j++;
            }
        }
        return result;

    }

    void visit(TreeNode root) {
        if(root == null) return;
        if(root.left != null) {
            visit(root.left);
        }
        treeNodeList.add(root.val);

        if(root.right != null) {
            visit(root.right);
        }

    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.fromString("[1,null,8]");
        TreeNode root2 = TreeUtils.fromString("[8,1]");
        PrintUtils.printIntList(new AllElementsInTwoBinarySearchTrees().getAllElements(root1, root2));
        PrintUtils.printIntList(new AllElementsInTwoBinarySearchTrees().getAllElements(
                TreeUtils.fromString("[2,1,4]"),
                TreeUtils.fromString("[1,0,3]")));

        PrintUtils.printIntList(new AllElementsInTwoBinarySearchTrees().getAllElements(
                TreeUtils.fromString("[0,-10,10]"),
                TreeUtils.fromString("[5,1,7,0,2]")));

        PrintUtils.printIntList(new AllElementsInTwoBinarySearchTrees().getAllElements(
                TreeUtils.fromString("[]"),
                TreeUtils.fromString("[5,1,7,0,2]")));

        PrintUtils.printIntList(new AllElementsInTwoBinarySearchTrees().getAllElements(
                TreeUtils.fromString("[0,-10,10]"),
                TreeUtils.fromString("[]")));
    }




}
