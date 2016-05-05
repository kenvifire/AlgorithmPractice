import java.util.Scanner;

/**
 * Created by hannahzhang on 16/5/5.
 */
public class H_InsertANodeAtTheTailOfALinkedList {

    public static void main(String[] args) {
        Node root = null;
        root = InsertHead(root, 1);
        Print(root);
        root = null;
        root = InsertHead(root, 1);
        root = InsertHead(root, 2);
        Print(root);



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

    static Node InsertHead(Node head,int data) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        Node dataNode = new Node();
        dataNode.data = data;


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



}

