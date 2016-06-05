package algo;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/5.
 */
public class H_Implentation_FindDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int N ;
        int count;
        while(T-->0) {
            count = 0;
            N = scanner.nextInt();
            int y = N;
            int mod = 0;
            while(N!=0) {
                mod = N%10;
                if(mod !=0 && y%mod == 0) {
                    count++;
                }
                N = N / 10;
            }
            System.out.println(count);
        }

    }
}
