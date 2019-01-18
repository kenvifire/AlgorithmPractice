package Leecode;

import java.util.ArrayList;
import java.util.List;

public class Prob_969 {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.length ; i++) {
            //find N
            int N = A.length - i;
            int idxN = find(A, N);
            if (idxN == N-1) continue;;
            //swap indN
            if(idxN != 0) {
                reverse(A, idxN);
                result.add(idxN + 1);
            }


            //swap N;
            if(N > 0) {
                reverse(A, N - 1);
                result.add(N);
            }
        }
        return result;


    }
    private int find(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if(a[i] == target) return i;
        }
        return -1;
    }

    private void reverse(int[] a, int K) {
       int left = 0, right = K;

       while (left <= right) {
           int temp = a[left];
           a[left] = a[right];
           a[right] = temp;
           left++;
           right--;
       }
    }
}
