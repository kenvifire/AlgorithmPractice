package Leecode;

import lib.ListNode;
import utils.AssertUtils;
import utils.ListUtils;


public class Prob_230 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;

        while (head != null && head.val == val ) {
            head = head.next;
        }

        if (head == null) return head;

        ListNode p = head;


        while (p.next != null) {
            if(p.next.val == val) {
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        return head;

    }

    public static void main(String[] args) {
        Prob_230 prob = new Prob_230();
        AssertUtils.equals("[1,2,3,4,5]", prob.removeElements(ListUtils.fromString("[1,2,3,6,4,5,6]"), 6).toString());
        AssertUtils.assertTrue(null == prob.removeElements(ListUtils.fromString("[6,6,6,6]"), 6));
        AssertUtils.equals("[2,3,4,5]", prob.removeElements(ListUtils.fromString("[6,2,3,6,4,5,6]"), 6).toString());
        AssertUtils.equals("[2,3,4,5]", prob.removeElements(ListUtils.fromString("[2,3,4,5]"), 6).toString());
        AssertUtils.equals("[1]", prob.removeElements(ListUtils.fromString("[1,2]"), 2).toString());
        AssertUtils.equals("[2]", prob.removeElements(ListUtils.fromString("[1,2]"), 1).toString());
    }
}
