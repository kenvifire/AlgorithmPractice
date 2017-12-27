package algo.hackrank.algo.uncategoried;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/14.
 */
public class H_Implementation_CaesarCiper {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder s = new StringBuilder(in.next());
        int k = in.nextInt() % 26;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c>='a' && c  <= 'z')   {
                c += k;
                if(c > 'z') {
                    c -=26;
                }

            }else if(c >= 'A' && c <= 'Z') {
                c += k;
                if(c > 'Z') {
                    c -=26;
                }
            }
            s.setCharAt(i,c);

        }

        System.out.println(s);

    }
}
