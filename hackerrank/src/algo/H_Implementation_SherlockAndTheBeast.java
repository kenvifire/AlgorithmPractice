package algo;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/4.
 */
public class H_Implementation_SherlockAndTheBeast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        int N;
        while (T-->0) {
            N = scanner.nextInt();
            int x = N;
            while (x % 3 != 0) {
                x -=5;
            }
            if (x < 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < x ; i++) {
                    System.out.printf("5");
                }
                for (int i = 0; i < (N-x); i++) {
                    System.out.printf("3");
                }
                System.out.println();

            }
        }
    }
}
