package Leecode;

import lib.ListNode;

public class Prob_61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = head;

        int len = 0;
        while (tail!= null) {
            tail = tail.next;
            len++;
        }
        k = k % len;

        if(k == 0) return head;

        ListNode kTail = head;
        while (k --> 0) kTail = kTail.next;
        return null;

    }
}
