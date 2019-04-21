package Leecode;

import lib.ListNode;
import lib.TreeNode;
import utils.ListUtils;

import java.util.HashMap;
import java.util.Map;

public class Prob_109 {
    Map<Integer, ListNode> posMap;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;

        posMap = new HashMap<>();
        int i = 0;
        ListNode phead = head;
        do {
            posMap.put(i, phead);
            phead = phead.next;
            i++;
        } while (phead != null);

        return constructTree(0, i - 1);
    }

    private TreeNode constructTree(int start, int end) {
        System.out.printf("%d-%d\n", start, end);
        if(start > posMap.size() - 1|| end > posMap.size() - 1 || start <0 || end < 0 || start > end) return null;
        if(start == end) return new TreeNode(posMap.get(start).val);
        int middle = (start + end) / 2;
        ListNode rootNode = posMap.get(middle);
        TreeNode root = new TreeNode(rootNode.val);
        root.left = constructTree(start, middle - 1);
        root.right = constructTree(middle + 1, end);
        return root;
    }

    public static void main(String[] args) {
        Prob_109 prob = new Prob_109();
        System.out.println(prob.sortedListToBST(ListUtils.fromString("[-10,-3,0,5,9]")));
    }






}
