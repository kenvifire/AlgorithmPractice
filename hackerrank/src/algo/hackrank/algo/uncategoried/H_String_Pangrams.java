package algo.hackrank.algo.uncategoried;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/21.
 */
public class H_String_Pangrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();

        BitSet bitSet = new BitSet(26);
        for (int i  = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if(Character.isAlphabetic(ch) && !bitSet.get(ch - 'a')) {
                bitSet.set(ch - 'a');
            }
        }

        if(bitSet.cardinality() == 26) {
            System.out.println("pangram");
        }else {
            System.out.println("not pangram");
        }
    }
}
