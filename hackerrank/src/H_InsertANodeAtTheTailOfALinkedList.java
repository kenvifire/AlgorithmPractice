import java.util.Scanner;

/**
 * Created by hannahzhang on 16/5/5.
 */
public class H_InsertANodeAtTheTailOfALinkedList {

    public static void main(String[] args) {
        Node rootA = null;
        Node rootB = null;
        rootA = Insert(rootA, 1);
        rootA = Insert(rootA, 1);
        rootA = Insert(rootA, 3);
        rootA = Insert(rootA, 3);
        rootA = Insert(rootA, 5);
        rootA = Insert(rootA, 6);

        //rootB = Insert(rootB, 1);
        //rootB = Insert(rootB, 2);
//        rootB = Insert(rootB, 6);
       // System.out.println(GetNode(rootA, 0));
       // System.out.println(GetNode(rootA, 1));
       // System.out.println(GetNode(rootA, 2));
       // System.out.println(GetNode(rootA, 3));
        Print(RemoveDuplicates(rootA));




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
    static Node MergeLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        Node pA = headA;
        Node pB = headB;
        Node head = null;
        Node p = null;
        while(pA != null && pB != null) {
            if(pA.data < pB.data) {
                if(p == null) {
                    head = pA;
                    p = pA;
                }else {
                    p.next = pA;
                    p = p.next;
                }
                pA = pA.next;
            }else {
                if(p == null) {
                    head = pB;
                    p = pB;
                }else {
                    p.next = pB;
                    p=p.next;
                }
                pB = pB.next;
            }
        }
        while(pA != null) {
            if(p == null) {
                return pA;
            }
            p.next = pA;
            pA = pA.next;
        }

        while(pB != null) {
            if(p == null) {
                return  pB;
            }
            p.next = pB;
            p = p.next;
            pB = pB.next;
        }


        return head;

    }

    static int GetNode(Node head,int n) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        Node p1 = head;
        Node p2 = head;
        while(n-->=0) {
            p1 = p1.next;
        }

        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2.data;

    }

    static Node RemoveDuplicates(Node head) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        if(head == null || head.next == null) {
            return head;
        }
        //init
        Node p1 = head;
        Node p2 = head.next;

        while(p2 != null) {
            // eq: remove node pointed by p2, p2 move on
            if(p1.data == p2.data) {
                p2 = p2.next;
                p1.next = p2;
            }
            // not eq: p1 p2 both move on
            else {
                p1 = p2;
                p2 = p2.next;

            }

        }
        return head;


    }




}

