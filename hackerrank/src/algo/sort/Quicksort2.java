package algo.sort;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/7/9.
 */
public class Quicksort2 {

    static void partition(int[] ar, int a_start, int a_end) {
        int length = a_end - a_start + 1;
        if(length <= 1) return;

        int val = ar[a_start];
        int[] tmp = new int[length];
        int front = 0, end = length-1;

        for (int i = a_start+1; i <= a_end; i++) {
            if(ar[i] <= val) {
                tmp[front++] = ar[i];
            }else {
                tmp[end--] = ar[i];
            }
        }
        tmp[front] = val;
        System.arraycopy(tmp, 0, ar, a_start, length);
        partition(ar, a_start, a_start + front - 1);
        partition(ar, a_start+ front + 1, a_end);
        printArray(ar, a_start, a_end);

    }

//    static int partition2(int[] ar, int lo, int hi) {
//        int i = lo, j = hi + 1;
//        int v = ar[hi];
//
//        while (true) {
//            while (ar[++i] < v ) if(i==hi) break;
//            while (v < ar[--j])   if(j == lo) break;
//            if(i >= j) break;
//            exch(ar, i, j);
//        }
//        exch(ar, hi ,j);
//        return j;
//    }
//
//    static void exch(int[] ar, int a, int b) {
//        int temp = ar[a];
//        ar[a] = ar[b];
//        ar[b] = temp;
//    }
//
//    static void sort(int[] ar, int lo, int hi) {
//        if(hi <= lo) return;
//        int j = partition2(ar, lo, hi);
//        sort(ar, lo, j-1);
//        sort(ar, j+1, hi);
//
//    }

    static void printArray(int[] ar, int start, int end) {
        for(int i = start; i <= end; i++){
            System.out.print(ar[i]+" ");
        }
        System.out.println("");
    }

    static void quickSort(int[] ar) {
        partition(ar, 0 ,ar.length-1);
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
        quickSort(ar);
    }
}
