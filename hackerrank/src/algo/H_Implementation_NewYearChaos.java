package algo;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/25.
 */
public class H_Implementation_NewYearChaos {
    public static void main(String[] args) {
        int T;
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();

        int n;
        int[] array;
        while (T --> 0) {
            n = scanner.nextInt();
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            boolean isChaotic = false;
            int totalCnt = 0;
            for (int i = array.length-1; i >= 0 ; i--) {
                if (array[i] - (i+1) > 2) {
                    isChaotic = true;
                    break;
                }
                for (int j = Math.max(0, array[i] - 2); j < i; j++) {
                    if(array[j] > array[i]) totalCnt++;
                }
            }

            if(isChaotic) {
                System.out.println("Too chaotic");
            }else {
                System.out.println(totalCnt);
            }
        }
    }

}
