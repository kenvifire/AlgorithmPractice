/**
 * Created by kenvi on 16/5/6.
 */
public class H_DoubleLinkedList {
    public static void main(String[] args) {

    }

    static class Node {
        int data;
        Node next;
        Node prev;
    }

    Node SortedInsert(Node head,int data) {
        if(head == null)
            return null;
        Node p = head;
        while(p.next != null && p.data < data) {
            p = p.next;
        }



    }

    static void Print(Node head) {
        Node p = head;
        while(p != null){
            System.out.println(p.data);
            p=p.next;
        }


    }
}
