package Leecode;

/**
 * https://leetcode.com/problems/print-immutable-linked-list-in-reverse/
 */
 interface ImmutableListNode {
     public void printValue(); // print the value of this node.
     public ImmutableListNode getNext(); // return the next node.
 };
public class PrintImmutableLinkedListInReverse {
    public void printLinkedListInReverse(ImmutableListNode head) {
        printV2(head);
    }

    private void print0(ImmutableList head ) {
        if(head != null) {
            if(head.getNext() != null) {
                print(head, head.getNext());
            } else {
                head.printValue();
            }
        }
    }
    private void print(ImmutableListNode prev, ImmutableListNode next) {
        if(next == null) {
            prev.printValue();
            return;
        }
        print(next, next.getNext());
        prev.printValue();
    }


    private void print(ImmutableListNode prev, ImmutableListNode next, ImmutableListNode tail) {
        if(next == null || (next == tail)) {
            prev.printValue();
            return;
        }
        print(next, next.getNext(), tail);
        prev.printValue();
    }

    private void printV2(ImmutableListNode head) {
        //find size
        int n = 0;
        ImmutableListNode p = head;
        while (p != null) {
            n ++;
            p = p.getNext();
        }
        //split
        int size = (int)Math.ceil(Math.sqrt(n));

        ImmutableListNode[] heads = new ImmutableListNode[(int)Math.ceil(n/(float)size) + 1];

        heads[0] = head;
        p = head;
        for (int i = 1; i < n; i++) {
            if(i % size == 0) {
               heads[i/size] = p.getNext();
            }
            p = p.getNext();
        }

        //print
        for (int i = heads.length - 1 ; i >0 ; i--) {
           print(heads[i-1], heads[i-1].getNext(), heads[i]);

        }
    }



    static class ImmutableList implements ImmutableListNode {
        private ImmutableListNode next;
        private int val;
        public ImmutableList(int val, ImmutableListNode next) {
           this.val = val;
           this.next = next;
        }
        public void printValue(){
           System.out.print(val);
        }
        public ImmutableListNode getNext() {
            return this.next;
        }
    }

    public static void main(String[] args) {
//        ImmutableList list = new ImmutableList(0, new ImmutableList(1, new ImmutableList(4, new ImmutableList(5, new ImmutableList(6, null)))));
//        ImmutableList list = new ImmutableList(0, new ImmutableList(2, null));
        ImmutableList list = new ImmutableList(0, null);

        PrintImmutableLinkedListInReverse sol = new PrintImmutableLinkedListInReverse();
        sol.printLinkedListInReverse(list);
    }
}
