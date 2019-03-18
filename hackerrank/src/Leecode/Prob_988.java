package Leecode;

import lib.TreeNode;
import utils.AssertUtils;
import utils.TreeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob_988 {
    public String smallestFromLeaf(TreeNode root) {
        List<String> strList = buildString(root);
        String min = strList.get(0);
        for (int i = 1; i < strList.size(); i++) {
            if(strList.get(i).compareTo(min) < 0) {
                min = strList.get(i);
            }
        }
        return min;
    }

    private List<String> buildString(TreeNode root) {
        if(root == null) return new ArrayList<>();
        if(root.left == null && root.right == null) {
            return Arrays.asList((char)(root.val + 'a') + "");
        }
        List<String> leftList = buildString(root.left);
        List<String> rightList = buildString(root.right);
        List<String> result = new ArrayList<>();
        for (String left : leftList) {
            result.add(left + (char)(root.val + 'a')  );
        }

        for (String right : rightList) {
            result.add(right + (char)(root.val + 'a'));
        }
        return result;

    }

    public static void main(String[] args) {
        Prob_988 prob = new Prob_988();
        AssertUtils.equals("dba", prob.smallestFromLeaf(TreeUtils.fromString("[0,1,2,3,4,3,4]")));
        AssertUtils.equals("adz", prob.smallestFromLeaf(TreeUtils.fromString("25,1,3,1,3,0,2")));
    }


}
