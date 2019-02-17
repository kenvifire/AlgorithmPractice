package Leecode;

import utils.AssertUtils;

public class Prob_995 {
    public int minKBitFlips(int[] A, int K) {
        int cnt = 0;
        for (int i = 0; i < A.length - K; i++) {
            if (A[i] == 0) {
               cnt ++;
               for (int j = i; j < i + K; j++) A[j] = 1;
            }
        }
        int zeroCnt = 0;

        for (int i = A.length - K ; i < A.length; i++) {
            zeroCnt ++;
        }

        if(zeroCnt == K || zeroCnt == 0) return cnt +1;
        return -1;
    }

    public static void main(String[] args) {
        Prob_995 prob = new Prob_995();
        AssertUtils.equals(2, prob.minKBitFlips(new int[]{0,1,0}, 1));
        AssertUtils.equals(-1, prob.minKBitFlips(new int[]{1,1,0}, 2));
    }
}
