package algo.hackrank.algo.uncategoried;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/21.
 */
public class H_String_theLoveLetterMystery {
    public static void main(String[] args) {
        int T;
        String line;
        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();
        scanner.nextLine();

        while (T --> 0) {
            int count = 0;
            line = scanner.nextLine();

            for (int i = 0; i < line.length() / 2 ; i++) {
                count += Math.abs(line.charAt(i) - line.charAt(line.length() - i - 1));
            }

            System.out.println(count);
        }
    }
}
