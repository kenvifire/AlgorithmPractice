package algo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/7.
 */
public class H_Implementation_CutTheSticks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
           a[i] = scanner.nextInt();
        }
        //sort
        Arrays.sort(a);

        int current = 0;
        int index = 0;

        while (index < N) {
            if(current != a[index]) {
                System.out.println(N-index);
                current=a[index];
            }else {
                index++;
            }
        }




    }
}
