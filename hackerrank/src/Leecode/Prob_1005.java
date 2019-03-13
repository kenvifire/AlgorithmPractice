package Leecode;

import java.util.Arrays;

public class Prob_1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int sum = 0;
        for (int i = 0; i < A.length; i++) sum += A[i];

        int i = 0;
        while (i < A.length &&A[i] < 0 && K-->0  ) sum += -2 * A[i++];

        if(K > 0 && K % 2 == 1) {
            if(i == 0) sum -= 2 *A[0];
            else sum -= 2 * Math.min(Math.abs(A[i-1]), Math.abs(A[i]));
        }
        return sum;
    }
}
