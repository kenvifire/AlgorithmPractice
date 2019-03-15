package Leecode;

import java.util.List;

public class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;

    static class ListNode {
        ListNode next;
        int val;

    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(size == 0 || index < 0 || index > size) return -1;
        ListNode p = head;

        int cnt = index;
        while (cnt > 0) p = p.next;
        return p.val;

    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode current = new ListNode();
        current.val = val;

        current.next = head;
        head = current;
        if(tail == null) tail = current;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode current = new ListNode();
        current.val = val;
        tail.next = current;
        tail = current;
        if(head == null) head = current;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index >= size) {
            addAtTail(val);
        } else {


            ListNode p = head;

            int cnt = index;

            while (cnt-- > 1) p = p.next;
            ListNode current = new ListNode();
            current.val = val;
            current.next = p.next;
            p.next = current;
            size++;
        }


    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        if (index == 0) head = head.next;


    }
}
