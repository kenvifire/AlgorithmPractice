import java.util.LinkedList;

/**
 * Created by hannahzhang on 16/5/6.
 */
public class H_Tree {
    public static void main(String[] args) {
        Node node1 = new Node();
        node1.data = 1;

        Node node2 = new Node();
        node2.data = 2;

        Node node3 = new Node();
        node3.data = 3;

        Node node4 = new Node();
        node4.data = 4;

        Node node5 = new Node();
        node5.data = 5;

        Node node6 = new Node();
        node6.data = 6;

        Node node7 = new Node();
        node7.data = 7;
//
        Node node8 = new Node();
        node8.data = 8;

        Node node9 = new Node();
        node9.data = 9;

        // structure
//        node4.left = node2;
//        node4.right = node7;
//
//        node2.left = node1;
//        node2.right = node3;



        //top_view(node1);
        Node root= Insert(node4, 4);
        LevelOrder(root);
        System.out.println();
        root = Insert_No_Recursive(root, 4);
        LevelOrder(root);
//        root = Insert(root, 7);
//        LevelOrder(root);
//        System.out.println();
//        root = Insert(root, 1);
//        LevelOrder(root);
//        System.out.println();
//        root = Insert(root, 3);
//        LevelOrder(root);
//        System.out.println();
//        root = Insert(root, 6);
//        LevelOrder(root);
//        System.out.println();

        //preOrder(node3);
        //System.out.println(height(node3));

    }
    static class Node {
        int data;
        Node left;
        Node right;
    }


    static void preOrder(Node root) {
        System.out.print(root.data);
        if(root.left != null) {
            preOrder(root.left);
        }
        if(root.right != null) {
            preOrder(root.right);
        }
    }

    static void postOrder(Node root) {
        if(root.left != null) {
            postOrder(root.left);
        }
        if(root.right != null) {
            postOrder(root.right);
        }
        System.out.print(root.data + " ");
    }
    static void inOrder(Node root) {
        if(root.left != null) {
            inOrder(root.left);
        }
        System.out.print(root.data + " ");
        if(root.right != null) {
            inOrder(root.right);
        }
    }

    static int height(Node root) {
        if (root == null)
            return 0;
        int lHeight = 0, rHeight = 0;
        if(root.left != null) {
            lHeight = 1 + height(root.left);
        }
        if(root.right != null) {
            rHeight = 1 + height(root.right);
        }

        return lHeight > rHeight ? lHeight : rHeight;
    }

    static  int count = 0;
    static void top_view(Node root)
    {
        if(root == null) {
            return;
        }

        if(root.left != null ) {
            top_view(root.left, true);
        }
        System.out.print(root.data + " ");

        if(root.right != null ) {
            top_view(root.right, false);
        }

    }

    static void top_view(Node root, boolean isLeft) {
        if(root == null)
            return;


        if(isLeft) {
            top_view(root.left, true);
        }

        System.out.print(root.data + " ");

        if(!isLeft) {
            top_view(root.right, false);
        }


    }

    static void LevelOrder(Node root)
    {
        if(root == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node current = queue.removeFirst();
            System.out.print(current.data + " ");
            if(current.left != null) {
                queue.addLast(current.left);
            }
            if(current.right != null) {
                queue.addLast(current.right);
            }

        }

    }

    static Node Insert(Node root,int value)
    {
        if(root == null)  {
            Node valueNode = new Node();
            valueNode.data = value;

            root = valueNode;
        }
        else if(value > root.data) {
            root.right = Insert(root.right, value);
        }else {
            root.left = Insert(root.left, value);
        }

        return root;

    }

    static Node Insert_No_Recursive(Node root, int value) {

        Node valueNode = new Node();
        valueNode.data = value;

        if(root == null) {
            return valueNode;
        }

        Node p = root;

        while(p != null) {
            if(value > p.data ) {
                if(p.right == null) {
                    p.right = valueNode;
                    return root;
                }else {
                    p = p.right;
                }
            }else {
                if(p.left == null) {
                    p.left = valueNode;
                    return root;
                }else {
                    p = p.left;
                }
            }
        }
        return root;


    }



}

