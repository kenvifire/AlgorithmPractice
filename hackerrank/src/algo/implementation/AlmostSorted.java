package algo.implementation;

import java.util.Scanner;

/**
 * Created by kenvi on 16/10/9.
 */
public class AlmostSorted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int i = 0, j = arr.length - 1;
        while (i < arr.length-1 && arr[i] < arr[i+1]) i++;
        while (j > i  && arr[j] >= arr[j-1]) j--;
        if(j == i ) {
            System.out.println("yes");
            return;
        }

        int ti = i-1;
        int tj = j+1;
        if(ti < 0) ti=0;
        if(tj >= arr.length) tj=arr.length-1;
        int sj = j;
        while (sj > 0 && arr[sj] < arr[j]) sj--;
        int tmp = arr[j];
        arr[j] = arr[sj];
        arr[sj] = tmp;
        while (tj > ti  && arr[tj] >= arr[tj-1]) tj--;
        if(tj == ti ) {
            System.out.println("yes\nswap " + (i+1) + " " + (j + 1));
            return;
        }


        //reverse
        ti = i+1;
        tj = j-1;

        while (ti<tj) {
            ti++;
            tj--;
            tmp = arr[ti];
            arr[ti] = arr[tj];
            arr[tj] = tmp;
        }


        //check
        ti = i-1;
        tj = j+1;
        if(ti < 0) ti=0;
        if(tj >= arr.length) tj=arr.length-1;

        while (ti < tj  && arr[ti] <= arr[ti+1]) ti++;

        if(tj == ti ) System.out.println("yes\nreverse " + (i+1) + " " + (j+1));
        else {
            System.out.println("no");
        }



    }
}
