/**
 * Created by kenvi on 16/5/6.
 */
public class H_DoubleLinkedList {
    public static void main(String[] args) {

        Node node2 = new Node();
        node2.data = 2;

        Node node4 = new Node();
        node4.data = 4;
        node2.next = node4;
        node4.prev = node2;

//        Node node5 = new Node();
//        node5.data = 5;
//        node4.next = node5;
//        node5.prev = node4;

        Node node6 = new Node();
        node6.data = 6;
        node4.next = node6;
        node6.prev = node4;



        //node2 = SortedInsert(node2, 5);
//        root = SortedInsert(root, 2);
//        root = SortedInsert(root, 3);
//        root = SortedInsert(root, 4);
//        root = SortedInsert(root, 6);

        node2 = Reverse(node2);
        Print(node2);
        Print(Reverse(null));
        //PrintReverse(node2);

    }

    static class Node {
        int data;
        Node next;
        Node prev;
    }

    static Node SortedInsert(Node head,int data) {
        Node dataNode = new Node();
        dataNode.data = data;
        if(head == null) {
            return dataNode;
        }

        Node p = head;
        while(p.next != null && p.data < data) {
            p = p.next;
        }
        //insert after tail
        if(p.next == null && p.data < data) {
            dataNode.prev = p;
            p.next = dataNode;
            return head;
        }

        //insert before head
        if(p.prev == null) {
            dataNode.next = p;
            p.prev = dataNode;
            return p;
        }
        //insert mid
        p.prev.next = dataNode;
        dataNode.prev = p.prev;
        dataNode.next = p;
        p.prev = dataNode;
        return head;



    }

    static void Print(Node head) {
        Node p = head;
        while(p != null){
            System.out.println(p.data);
            p=p.next;
        }


    }

    static void PrintReverse(Node tail) {
        Node p = tail;
        while (p != null) {
            System.out.println(p.data);
            p = p.prev;
        }
    }

    static Node Reverse(Node head) {
        Node p = head;
        Node newHead = head;
        while (p != null) {
            Node prev = p.prev;
            p.prev = p.next;
            p.next = prev;
            newHead = p;
            p = p.prev;
        }
        return newHead;


    }
}
