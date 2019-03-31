package Leecode;

import lib.ListNode;
import utils.ListUtils;
import utils.PrintUtils;

public class Prob_1030 {
    public int[] nextLargerNodes(ListNode head) {
        ListNode p = head;
        int len = 0;
        while (p != null) {len++; p = p.next;}

        if(len == 0) return new int[0];
        if(len == 1) return new int[1];

        int[] arry = new int[len];
        p = head;
        int idx = 0;
        while (p != null) {
            arry[idx++] = p.val;
            p = p.next;
        }

        int[] result = new int[len];

        for (int i = 0; i < result.length - 1; i++) {
            for ( int  j = i + 1; j < result.length; j++) {
                if(arry[j] > arry[i]) {
                    result[i] = arry[j];
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Prob_1030 prob = new Prob_1030();
        PrintUtils.printArray(prob.nextLargerNodes(ListUtils.fromString("[1,7,5,1,9,2,5,1]")));
    }
}
