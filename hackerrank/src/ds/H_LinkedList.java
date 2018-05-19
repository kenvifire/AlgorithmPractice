import sun.jvm.hotspot.utilities.Assert;

import java.util.*;

/**
 * Created by hannahzhang on 16/5/5.
 */
public class H_LinkedList {

    public static void main(String[] args) {
        Node rootA = null;
        Node rootB = null;
        rootA = Insert(rootA, 1);
        rootA = Insert(rootA, 2);
        rootA = Insert(rootA, 3);
        //Node mergeNode = GetNode(rootA,2);

        rootB = Insert(rootB,1);




        //rootB = Insert(rootB, 1);
        //rootB = Insert(rootB, 2);
//        rootB = Insert(rootB, 6);
       // System.out.println(GetNode(rootA, 0));
       // System.out.println(GetNode(rootA, 1));
       // System.out.println(GetNode(rootA, 2));
       // System.out.println(GetNode(rootA, 3));
//        System.out.println(FindMergeNode(rootA, rootB));

        int count = 100;

        while (count -- > 1) {
            int k = 100;
            while (k --> 0) {
                int len1 = new Random().nextInt(100);
                int len2 = new Random().nextInt(100);
                int bound = Math.abs(new Random().nextInt(count) + 1) + 1;


                validate(generateRandomArray(bound, len1), generateRandomArray(bound,len2));
            }


        }


    }
    static class Node {
        int data;
        Node next;


        @Override
        public String toString() {
            return String.valueOf(data) + "," + (next == null? "": next.toString());
        }

    }

    static int[] generateRandomArray(int bound, int length) {
        if (length == 0) return null;
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(bound);
        }
        Arrays.sort(array);
        return array;
    }

    static void validate(int[] list1, int[] list2) {
        if(list1 == null || list2 == null) {
            System.out.println("list 1:" + Arrays.toString(list1));
            System.out.println("list 2:" + Arrays.toString(list2));
        }
        Node linkeList1 = list1 == null ? null : generateList(list1);
        Node linkedList2 = list2 == null ? null : generateList(list2);
        String actual = MergeLists(linkeList1, linkedList2).toString();

        int length = (list1 == null ? 0 : list1.length) + (list2 == null ? 0 : list2.length);
        int[] resultList = new int[length];

        if (list1 == null) {
            resultList = Arrays.copyOf(list2, list2.length);
        } else if(list2 == null) {
            resultList = Arrays.copyOf(list1, list1.length);
        } else {
            System.arraycopy(list1, 0, resultList, 0, list1.length);
            System.arraycopy(list2, 0, resultList, list1.length, list2.length);
        }
        Arrays.sort(resultList);

        String expected = generateList(resultList).toString();

        Assert.that(actual.equals(expected), String.format("expected:[%s], actual[%s]", expected, actual));
    }

    static Node generateList(int... data) {

        Node head = null;
        Node tail = null;
        for (int d : data) {
            Node node = new Node();
            node.data=d;

            if(head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }

        }
        return head;
    }

    static Node Insert(Node head, int data) {
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
        if (headA == null) return headB;
        if (headB == null) return headA;

        Node pA = headA;
        Node pB = headB;
        Node head = null;
        Node tail = null;
        Node p = null;

        //merge too not empty lists

        while(pA != null && pB != null) {
            if (pA.data < pB.data) {
                p = pA;
                pA = pA.next;
            } else {
                p = pB;
                pB = pB.next;
            }
            if (head == null) {
                head = p;
                tail = p;
            } else {
                tail.next = p;
                tail = tail.next;
            }
        }

        //append first list if there's more elements
        if (pA != null) {
            tail.next = pA;
        }

        //append second list if there's more elements
        if (pB != null) {
            tail.next = pB;
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

    static int HasCycle(Node head) {
        if(head == null || head.next == null) {
            return 0;
        }
        Node p1 = head;
        Node p2 = head.next.next;

        while(p2!=null && p2.next != null) {
            if(p1 == p2) return 1;
            p1 = p1.next;
            p2 = p2.next.next;
        }

       return 0;


    }

    static int FindMergeNode(Node headA, Node headB) {
        // Complete this function
        // Do not write the main method.
        HashSet<Node> visited = new HashSet<Node>();
        Node p = headA;
        while(p != null) {
            visited.add(p);
            p = p.next;
        }
        p = headB;
        while (p != null) {
            if(visited.contains(p)) {
                return p.data;
            }
            p = p.next;
        }

        return 0;

    }

    static int FindMergeFast(Node headA, Node headB) {
        Node pA = headA;
        Node pB = headB;

        while (pA != pB) {
            if(pA == null ) {
                pA = headB;
            }else {
                pA = pA.next;
            }

            if(pB == null) {
                pB = headA;
            }else {
                pB = pB.next;
            }
        }

        return pA.data;
    }


}

