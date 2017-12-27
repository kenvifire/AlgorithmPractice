package algo.hackrank.algo.uncategoried;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/21.
 */
public class H_String_GemStones {
    public static void main(String[] args) {
        int N ;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();
        String line;
        Map<Character,Integer> alphabetsMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            alphabetsMap.put((char)('a' + i) , 0);
        }
        BitSet bitSet = new BitSet(26);
        for (int j = 0; j < N; j++) {
            bitSet.clear();
            line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if(!bitSet.get(ch - 'a')) {
                    Integer value = alphabetsMap.get(ch);
                    alphabetsMap.put(ch, value + 1);
                    bitSet.set(ch - 'a');
                }
            }
        }
        int count = 0;

        for (Map.Entry<Character,Integer> entry : alphabetsMap.entrySet()) {
            if (entry.getValue() == N) {
               count++;
            }
        }
        System.out.println(count);

    }
}
