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
            root = valNode;
        }else if(val < root.val) {
            root.left = insert(root.left, val);

            if (height(root.left) - height(root.right) == 2) {
                if (val < root.left.val) {
                    root = rotateLeftChild(root);
                } else {
                    root = doubleRotateLeftChild(root);
                }
            }
        } else if(val > root.val) {
            root.right  = insert(root.right, val);
            if(height(root.right) - height(root.left) == 2) {
                if (val > root.right.val)  {
                    root = rotateRightChild(root);
                }else {
                    root = doubleRotateRightChild(root);
                }
            }
        }else {
            //nothing for dup
        }

        root.ht = Math.max(height(root.left), height(root.right)) + 1;

        return root;
    }

    static int height(Node node) {
        return node == null ? -1 : node.ht;
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

    static Node rotateLeftChild(Node n) {
        Node c = n;
        Node b = n.left;
        c.left = b.right;
        b.right = c;
        c.ht = Math.max(height(c.left), height(c.right)) + 1;
        b.ht = Math.max(height(b.left), c.ht) + 1;
        return b;
    }

//   static Node delete(Node root, int val) {
//       if (root == null) {
//           return null;
//       }else if(val < root.val)  {
//
//       }else if(val > root.val) {
//
//       }else if(val == root.val) {
//
//       }
//
//
//   }



    /**
     *  A(0)
     *   \
     *    B(1) ==>     B(0)
     *     \          / \
     *      C(2)     A(1)C(1)
     * @param n
     * @return
     */
    static Node rotateRightChild(Node n) {
        Node a = n;
        Node b = n.right;
        a.right = b.left;
        b.left = a;
        a.ht = Math.max(height(a.left), height(a.right)) + 1;
        b.ht = Math.max(height(b.right), a.ht) + 1;
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
    static Node doubleRotateLeftChild(Node n) {
        n.left =  rotateRightChild(n.left);

       return rotateLeftChild(n);

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
    static Node doubleRotateRightChild(Node n) {
        n.right = rotateLeftChild(n.right);
        return rotateRightChild(n);

    }


    public static void main(String[] args){
        Node root = insert(null, 1);
        root = insert(root ,2);
        root = insert(root ,3);
        root = insert(root ,4);
        root = insert(root ,5);
        root = insert(root ,6);

    }
}
