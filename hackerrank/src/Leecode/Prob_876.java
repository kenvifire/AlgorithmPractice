package Leecode;

import lib.ListNode;

public class Prob_876 {
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode head1 = head;
        ListNode head2 = head;

        while(head2 != null & head2.next != null)  {
            head1 = head1.next;
            head2 = head2.next.next;
        }

        return head1;

    }
}
