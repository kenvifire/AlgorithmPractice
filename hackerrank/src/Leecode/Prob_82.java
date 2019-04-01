package Leecode;

import lib.ListNode;
import utils.AssertUtils;
import utils.ListUtils;

public class Prob_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pHead = null;

        ListNode curr = head.next;
        ListNode tail = null;
        ListNode prev = head;
        int cnt = 1;
        int prevVal = head.val;

        while (curr != null) {
            if(curr.val == prevVal) {
               //nothing
                cnt++;
            } else {
               if(cnt == 1)  {
                   if(pHead == null) {
                       pHead = prev;
                       tail = prev;
                   } else {
                       tail.next = prev;
                       tail = tail.next;
                   }
               }
               else {
                   if(tail != null)
                    tail.next = null;
               }
               prevVal = curr.val;
               cnt = 1;
               prev = curr;
            }
            curr = curr.next;

        }
        if(cnt == 1) {
            if (pHead == null) {
                pHead = prev;
            } else {
                tail.next = prev;
            }
        } else {
            if(tail != null) tail.next = null;
        }

        return pHead;

    }

    public static void main(String[] args) {
//        Prob_82 prob = new Prob_82();
//        ListNode head = prob.deleteDuplicates(ListUtils.fromString("[1,1,2,2,3,3,4,4,5,5]"));
//        AssertUtils.equals("[2]", head.toString());
//        ListNode head = prob.deleteDuplicates(ListUtils.fromString("[1,2,2]"));
//        AssertUtils.equals("[1]", head.toString());

    }
}
