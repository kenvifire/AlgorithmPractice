import java.util.Scanner;

/**
 * Created by hannahzhang on 16/5/5.
 */
public class H_InsertANodeAtTheTailOfALinkedList {

    public static void main(String[] args) {
        Node rootA = null;
        Node rootB = null;
        System.out.println(CompareLists(rootA, rootB));
        rootA = Insert(rootA, 1);
        System.out.println(CompareLists(rootA, rootB));
        rootB = Insert(rootB, 1);
        System.out.println(CompareLists(rootA, rootB));
        rootB = Insert(rootB, 1);
        System.out.println(CompareLists(rootA, rootB));



    }
    static class Node {
        int data;
        Node next;
    }

    static Node Insert(Node head,int data) {
    // This is a "method-only" submission.
    // You only need to complete this method.
        Node dataNode = new Node();
        dataNode.data = data;

        Node p = head;

        while(p != null && p.next != null){
            p = p.next;
        }
        if(p == null) {
            dataNode.next = null;
            p = dataNode;
            head=p;
        }else {
            Node tmp = p.next;
            p.next = dataNode;
            dataNode.next = tmp;
        }
        return head;
    }

    static Node InsertHead(Node head,int x) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        Node dataNode = new Node();
        dataNode.data = x;


//        if(head == null) {
//            return dataNode;
//        }

        dataNode.next = head;


        return dataNode;
    }

    static void Print(Node head) {
        Node p = head;
        while(p != null){
            System.out.println(p.data);
            p=p.next;
        }


    }

    static Node InsertNth(Node head, int data, int position) {
        Node dataNode = new Node();
        dataNode.data = data;
        //insert head
        if (position == 0 || head == null) {
            dataNode.next = head;
            return dataNode;
        }

        //insert after head

        Node p = head;
        int pos = position;

        while (pos --> 1 && p.next != null) {
            p = p.next;
        }

        dataNode.next = p.next;
        p.next = dataNode;

        return head;

    }

    static Node Delete(Node head, int position) {
        if(head == null) {
            return head;
        }
        //delete at head
        if (position == 0) {
            return head.next;
        }

        //delete after head
        Node p = head;
        int pos = position;
        while (pos --> 1 && p.next != null) {
            p = p.next;
        }

        p.next = p.next.next;
        return head;

    }

    static void ReversePrint(Node head) {
         if(head != null ){
            ReversePrint(head.next);
            System.out.println(head.data);
         }

    }
    static Node Reverse(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        //head1-->head2-->head lHead-->
        Node lHead = Reverse(head.next);
        head.next.next = head;
        head.next = null;
        return lHead;


    }

    static int CompareLists(Node headA, Node headB) {
        Node pA = headA;
        Node pB = headB;
        while(pA != null && pB != null) {
            if (pA.data != pB.data) {
                return 0;
            }
            pA = pA.next;
            pB = pB.next;
        }

        if(pA != null || pB != null) {
            return 0;
        }

        return 1;


    }





}

