package algo;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/21.
 */
public class H_String_alternatingCharaters {
    public static void main(String[] args) {
        int T;
        String line;
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        scanner.nextLine();
        while (T --> 0) {
            int count = 0;
            line = scanner.nextLine();
            char current = line.charAt(0);
            for (int i = 1; i < line.length(); i++) {
               if(line.charAt(i) == current) {
                  count++;
               }else {
                   current = line.charAt(i);
               }
            }
            System.out.println(count);
        }
    }
}
