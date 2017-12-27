package algo.hackrank.algo.uncategoried;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/21.
 */
public class H_String_FunnyString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        while (T --> 0) {
            String line = scanner.nextLine();
            if(isFunny(line))  {
                System.out.println("Funny");
            }else {
                System.out.println("Not Funny");
            }
        }
    }
    public static boolean isFunny(String string) {
        String reverse = new StringBuilder(string).reverse().toString();
        for (int i = 1; i < string.length() ; i++) {
            if(Math.abs(string.charAt(i) - string.charAt(i-1))
                    !=
                    Math.abs(reverse.charAt(i) - reverse.charAt(i-1))) {
                return false;
            }
        }
        return true;
    }
}
