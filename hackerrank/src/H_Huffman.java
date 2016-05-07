/**
 * Created by hannahzhang on 16/5/7.
 */
public class H_Huffman {

    public static void main(String[] args) {

    }

    static class Node {
        int frequency; // the frequency of this tree
        char data;
        Node left, right;
    }


    static void decode(String S ,Node root)
    {
        int index = 0;
        Node p = root;

        while(index < S.length()) {
            char c = S.charAt(index);
            if(c == '1') {// right
                p = p.right;
            }else { //left
                p = p.left;
            }

            if(p.left == null && p.right == null) {
                System.out.print(p.data);
                p = root;
            }
            index++;
        }

    }
}
