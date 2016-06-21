package algo;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/21.
 */
public class H_String_PalindromeIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String line;

        scanner.nextLine();
        while (T --> 0) {
            line = scanner.nextLine();
            System.out.println(isPalindrome(line, 0, line.length()-1));

        }

    }

    public static Integer isPalindrome(String str, int start , int end) {
        if(str == null  || start == end || start == end+1 ){
            return -1;
        }else if(str.charAt(start) == str.charAt(end)) {
           return isPalindrome(str, start+1, end-1);
        }else {
            return start;
        }
    }
}
