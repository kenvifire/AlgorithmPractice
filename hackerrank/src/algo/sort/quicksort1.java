package algo.sort;

import java.util.Scanner;

/**
 * Created by kenvi on 16/7/7.
 */
public class quicksort1 {
    static void partition(int[] ar) {
        int val = ar[0];
        int[] tmp = new int[ar.length];
        int front =0, end = ar.length-1;

        for (int i = 1; i < ar.length; i++) {
           if(ar[i] <= val) {
               tmp[front++] = ar[i];
           }else {
               tmp[end--] = ar[i];
           }
        }
        tmp[front] = val;
        printArray(tmp);

    }

    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        partition(ar);
    }
}
