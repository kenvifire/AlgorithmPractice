package algo;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/19.
 */
public class A_Implementation_LarryasArray {
    public static void main(String[] args) {
        int T, N;
        int[] a;
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();

        while (T --> 0) {
             N = scanner.nextInt();
            a = new int[N];
            for (int i = 0; i < N; i++) {
               a[i] = scanner.nextInt();
            }
            if(checkArray(a)) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
            
        }

    }

    public static boolean checkArray(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[i]) {
                    count++;
                }
            }


        }
        return count %2 == 0;
    }
}
