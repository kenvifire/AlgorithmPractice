package algo.hackrank.algo.uncategoried;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/21.
 */
public class H_String_Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        String line;
        int s = 0;
        while (T --> 0) {
            Map<Character,Integer> s1 = new HashMap<>(), s2 = new HashMap<>();
            for (int i = 0; i < 26; i++) {
                s1.put((char)('a' + i), 0);
                s2.put((char)('a' + i), 0);
            }
            line = scanner.nextLine();
            if(line.length() %2 == 1) {
                System.out.println("-1");
            }else {
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if(i < line.length() / 2) {
                        Integer value = s1.get(ch);
                        s1.put(ch, value+1);
                    }else {
                        Integer value = s2.get(ch);
                        s2.put(ch, value+1);
                    }
                }
                int count = 0;
                for (int i = 0; i < 26; i++) {
                    char ch = (char)('a' + i);
                    count += Math.abs(s1.get(ch)-s2.get(ch));
                }
                System.out.println(count/2);

            }
        }
    }
}
