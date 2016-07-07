package algo.sort;

import java.util.Scanner;

/**
 * Created by kenvi on 16/7/7.
 */
public class InsertionSort2 {
    public static void insertionSortPart2(int[] ar)
    {
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided
        for (int i = 2; i <= ar.length; i++) {
            insertIntoSorted(ar, i);
            printArray(ar);
        }

    }

    public static void insertIntoSorted(int[] ar, int length) {
        if(length == 1) return;
        int v = ar[length-1];
        int pos = length-2;
        while (pos >=0 && ar[pos] > v ) {
            ar[pos+1] = ar[pos];
            pos--;
        }
        if(pos != length -2) {
            ar[pos + 1] = v;
        }

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertionSortPart2(ar);

    }
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
