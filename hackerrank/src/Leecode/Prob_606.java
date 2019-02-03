package Leecode;

import lib.TreeNode;

public class Prob_606 {
    public String tree2str(TreeNode t) {
        if(t == null )  return "";

        StringBuilder sb = new StringBuilder();

        boolean leftOmit = t.left == null && t.right == null;
        boolean rightOmit = t.right == null;

        String left = tree2str(t.left);

        String right = tree2str(t.right);

        sb.append(t.val);
        if(!leftOmit)
            sb.append("(").append(left).append(")");
        if(!rightOmit)
            sb.append("(").append(right).append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        root.left = node2;
        root.right = node3;

        node2.left = node4;

        System.out.println(new Prob_606().tree2str(root));
    }
}
