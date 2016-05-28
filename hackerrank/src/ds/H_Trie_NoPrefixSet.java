package ds;


import java.util.Scanner;

/**
 * Created by kenvi on 16/5/28.
 */
public class H_Trie_NoPrefixSet {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();
        TrieST root = new TrieST();

        String line = null;
        while( N --> 0) {
            line = scanner.nextLine();
            if(root.isBad) {
                continue;
            }
            root.put(line);

        }

        if (root.isBad()) {
            System.out.println("BAD SET");
            System.out.println(root.firstConflict);
        }else {
            System.out.println("GOOD SET");
        }

    }

    static class TrieST {
        private static int R = 26;
        private Node root = new Node();
        private boolean isBad = false;
        private String firstConflict = null;

        public boolean isBad() {
            return isBad;
        }

        public

        class Node {
            private Integer val = 0;
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
                x.val = 0;
            }else {
                if(x.val == 0 && x != root) {
                     if(!isBad) {
                        isBad = true;
                        firstConflict = key;
                     }

                }
            }

            if(d == key.length()) {
                if(x.val > 0) {
                    if(!isBad) {
                        isBad = true;
                        firstConflict = key;
                    }
                }
                return x;
            }

            char c = key.charAt(d);
            x.next[c - 'a'] = put(x.next[c - 'a'], key, d+1);
            x.val = x.val + 1;

            return x;
        }

    }
}
