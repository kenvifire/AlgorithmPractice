package Leecode;

import lib.ListNode;

public class Prob_237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }
}
