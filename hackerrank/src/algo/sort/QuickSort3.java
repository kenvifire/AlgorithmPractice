package algo.sort;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/7/9.
 */
public class QuickSort3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        quickSort(ar,0, ar.length-1);
    }

    static void quickSort(int[] ar, int start, int end) {

        sort(ar, 0 , ar.length-1);
    }

    static int partition2(int[] ar, int lo, int hi) {
        int i = lo-1, j = hi ;
        int v = ar[hi];

        while (true) {
            while (ar[++i] < v ) if(i==hi) break;
            while (v < ar[--j])   if(j == lo) break;
            if(i >= j) break;
            exch(ar, i, j);
        }
        exch(ar, hi ,i);
        return i;
    }

    static void exch(int[] ar, int a, int b) {
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }

    static void sort(int[] ar, int lo, int hi) {
        if(hi <= lo) return;
        int j = partition2(ar, lo, hi);
        printArray(ar);
        sort(ar, lo, j-1);
        sort(ar, j+1, hi);

    }

    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
