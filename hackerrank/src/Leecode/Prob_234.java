package Leecode;

import lib.ListNode;
import utils.AssertUtils;
import utils.ListUtils;

import java.util.List;

public class Prob_234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        if(head.next == null) return true;

        ListNode p1 = head;
        ListNode p2 = head;

        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode mid = p1;

        ListNode second = mid.next;
        mid.next = null;


        second = reverse(second);


        ListNode first = head;
        while (first != null && second != null) {
           if(first.val != second.val)  return false;
           first = first.next;
           second = second.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {

        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }

        return prev;
    }

    public static void main(String[] args) {
        Prob_234 prob = new Prob_234();

        AssertUtils.assertTrue(prob.isPalindrome(ListUtils.fromString("[]")));
        AssertUtils.assertTrue(prob.isPalindrome(ListUtils.fromString("[1]")));
        AssertUtils.assertTrue(prob.isPalindrome(ListUtils.fromString("[1,1]")));
        AssertUtils.assertTrue(prob.isPalindrome(ListUtils.fromString("[1,2,1]")));
        AssertUtils.assertTrue(prob.isPalindrome(ListUtils.fromString("[1,2,2,1]")));

        AssertUtils.assertFalse(prob.isPalindrome(ListUtils.fromString("[1,2]")));
        AssertUtils.assertFalse(prob.isPalindrome(ListUtils.fromString("[1,2,3]")));
        AssertUtils.assertFalse(prob.isPalindrome(ListUtils.fromString("[1,2,3]")));
    }
}
