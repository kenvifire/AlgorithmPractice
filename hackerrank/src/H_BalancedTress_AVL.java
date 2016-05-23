/**
 * Created by kenvi on 16/5/23.
 */
public class H_BalancedTress_AVL {
    static class Node {
        int val;
        int ht;
        Node left;
        Node right;
    }

    static Node insert(Node root, int val) {
        Node valNode = new Node();
        valNode.val = val;

        if(root == null) {
            valNode.ht = 1;
            return valNode;
        }
        Node parentNode =  null;
        Node currentNode = root;
        while(true) {
            parentNode = currentNode;
            if(val < parentNode.val) {
                currentNode = currentNode.left;
                if(currentNode == null) {
                    parentNode.left = valNode;
                    valNode.ht = parentNode.ht + 1;

                    return root;
                }
            }else {
                currentNode = currentNode.right;
                if(currentNode == null) {
                    parentNode.right = valNode;
                    valNode.ht = parentNode.ht + 1;
                    return root;
                }
            }


        }

    }

    /**
     *     C(0)
     *    /
     *   B(1)      ==>       B (0)
     *  /                   / \
     * A(2)                A(1)C(1)
     * @param n
     * @return
     */

    static Node rightRotate(Node n) {
        Node c = n;
        Node b = n.left;
        Node a = b.left;
        b.ht = b.ht - 1;
        c.ht = c.ht + 1;
        a.ht = a.ht - 1;


        b.right = c;
        c.left = null;
        return b;
    }




    /**
     *  A(0)
     *   \
     *    B(1) ==>     B(0)
     *     \          / \
     *      C(2)     A(1)C(1)
     * @param n
     * @return
     */
    static Node leftRotate(Node n) {
        Node b = n.right;
        Node a = n;
        Node c = b.right;

        b.ht = b.ht -1;
        a.ht = a.ht + 1;
        c.ht = c.ht - 1;

        b.left = a;
        a.right = null;

        return b;
    }

    /**
     *     C               C
     *    /               /
     *   A       ==>     B    ==>    B
     *    \             /           / \
     *     B           A           A   C
     * @param n
     * @return
     */
    static Node leftRightRotate(Node n) {
        Node c = n;
        Node a = c.left;
        Node b = a.right;
        a.ht = a.ht + 1;
        b.ht = b.ht - 1;

        c.left = b;
        b.left = a;
        a.right = null;
        return leftRotate(c);

    }

    /**
     *    B                B
     *     \                \
     *      C     ==>        A      ==>      A
     *     /                  \             / \
     *    A                    C           B   C
     *
     * @param n
     * @return
     */
    static Node rightLeftRotate(Node n ) {
        Node b = n;
        Node c = n.right;
        Node a = c.left;
        a.ht = a.ht - 1;
        b.ht = b.ht + 1;

        b.right = a;
        a.left = c;
        c.left = null;

        return rightRotate(a);
    }


    public static void main(String[] args){
        //TODO
    }
}
