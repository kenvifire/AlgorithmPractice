import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by hannahzhang on 16/5/7.
 */
public class H_SWAP_NODES_ALGO {

    static class  Node {
        Node left;
        Node right;
        int data;
        int height;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        N = scanner.nextInt();
        Node root = new Node();
        root.data = 1;
        root.height = 1;
        int a,b;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.addLast(root);
        while(N-->0) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            Node current = queue.removeFirst();
            if(a != -1 ) {
                Node left = new Node();
                left.data = a;
                left.height = current.height + 1;
                current.left = left;
                queue.addLast(left);

            }

            if(b != -1 ) {
                Node right = new Node();
                right.data = b;
                right.height = current.height + 1;
                current.right = right;
                queue.addLast(right);
            }
        }
        int T;
        T = scanner.nextInt();
        int K;
        while (T-->0) {
            K = scanner.nextInt();
            InOrderSwap(root, K);
            InOrder(root);
            System.out.println();

        }

    }

    static void InOrderSwap(Node root, int height) {
        if(root == null) {
            return;
        }
        Node left = root.left;
        Node right = root.right;

        if(root.height % height == 0) {
            root.left = right;
            root.right = left;
        }

        InOrderSwap(left, height);
        InOrderSwap(right, height);

    }

    static void InOrder(Node root) {
        if(root == null) {
            return;
        }

        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }

}
