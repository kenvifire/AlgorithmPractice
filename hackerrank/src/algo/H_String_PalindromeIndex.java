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
        while (T-- > 0) {
            line = scanner.nextLine();
            int l = 0, r = line.length() - 1;
            while (l < r) {
                if(line.charAt(l) == line.charAt(r)) {
                    l++;
                    r--;
                }else {
                    break;
                }
            }
            System.out.println(new StringBuilder(line).reverse());
            if(l >= r) {
                System.out.println(-1);
                continue;
            }

            if(line.charAt(l+1) == line.charAt(r)) {
                System.out.println(l);
            }else {
                System.out.println(r);
            }

        }

    }

}


