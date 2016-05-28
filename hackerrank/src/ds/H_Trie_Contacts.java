package ds;


import java.util.Scanner;

/**
 * Created by kenvi on 16/5/28.
 */
public class H_Trie_Contacts {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();
        TrieST root = new TrieST();

        String line = null;
        String[] array = null;
        while( N --> 0) {
            line = scanner.nextLine();
            array = line.split(" ");
            if(array[0].equals("add")) {
                root.put(array[1]);

            }else {
                Integer value = root.get(array[1]);
                if(value == null) {
                    System.out.println(0);
                }else {
                    System.out.println(value);
                }

            }
        }

    }

    static class TrieST {
        private static int R = 26;
        private Node root = new Node();

        class Node {
            private Integer val = 1;
            private Node[] next = new Node[R];
        }
        public Integer get(String key) {
            Node x = get(root, key, 0);
            if (x == null) return null;
            return x.val;
        }

        private Node get(Node x, String key, int d) {
            if (x == null) return null;
            if (d == key.length()) return x;
            char c = key.charAt(d);
            return get(x.next[c-'a'], key, d+1);
        }

        public void put(String key) {
            root = put(root, key, 0);
        }

        private Node put(Node x, String key, int d) {
            if (x == null) {
                x = new Node();
                x.val = 1;
            }else {
                x.val = x.val + 1;
            }
            if(d == key.length()) {
                return x;
            }

            char c = key.charAt(d);
            x.next[c - 'a'] = put(x.next[c - 'a'], key, d+1);
            return x;
        }

    }
}
