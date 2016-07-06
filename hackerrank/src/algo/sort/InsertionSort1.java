package algo.sort;

import java.util.Scanner;

/**
 * Created by kenvi on 16/7/6.
 */
public class InsertionSort1 {
    public static void insertIntoSorted(int[] ar) {
        if(ar.length == 1) return;
        int v = ar[ar.length-1];
        int pos = ar.length-2;
        while (pos >=0 && ar[pos] > v ) {
            ar[pos+1] = ar[pos];
            printArray(ar);
            pos--;
        }
        if(pos != ar.length -2) {
            ar[pos + 1] = v;
            printArray(ar);
        }

    }


    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
