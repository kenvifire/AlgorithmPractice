package Leecode;

import java.util.Arrays;

public class Prob_908 {
    public int smallestRangeI(int[] A, int K) {
        if(A.length <= 1) return 0;
        Arrays.sort(A);
        int len = A.length;
        int distance = Math.abs(A[len -1] - A[0]);

        if(2 * K > distance) return 0;
        return distance - 2 * K;


    }
}
