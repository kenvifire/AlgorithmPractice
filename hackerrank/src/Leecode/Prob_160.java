package Leecode;

import lib.ListNode;
import utils.AssertUtils;

import java.util.List;

public class Prob_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode pA = headA, pB = headB;
        boolean flagA = false, flagB = false;
        while (pA != pB) {
            if(pA == null) {
                if(!flagA) {
                    pA = headB;
                    flagA = true;
                } else {
                    return null;
                }

            } else {
                pA = pA.next;
            }

            if(pB == null) {
                if(!flagB) {
                    pB = headA;
                    flagB = true;
                } else {
                    return null;
                }
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        a1.next = a2;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        b1.next = b2;

        Prob_160 prob = new Prob_160();

        AssertUtils.assertTrue(prob.getIntersectionNode(a1, b1) == null);

        a1.next = b2;

        AssertUtils.assertTrue(prob.getIntersectionNode(a1, b1) == b2);

        AssertUtils.assertTrue(prob.getIntersectionNode(b1, b2) == b2);

    }
}
