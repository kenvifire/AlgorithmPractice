package Leecode;

import lib.ListNode;

public class Prob_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseList(head.next);
        node.next.next = head;
        head.next = null;
        return node;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);

        ListNode node2 = new ListNode(2);
        ListNode head = new ListNode(3);

        head.next = node2;
        node2.next = node;

        ListNode newHead = new Prob_206().reverseList(head);
    }
}
