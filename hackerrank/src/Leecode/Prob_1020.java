package Leecode;

import utils.AssertUtils;

public class Prob_1020 {
    public boolean canThreePartsEqualSum(int[] A) {
        if(A.length < 3) return false;
        int sum = 0;
        for (int a : A) {
            sum += a;
        }

        if(sum % 3 != 0) return false;

        int avg = sum / 3;
        int localSum = 0;
        int cnt = 0;

        for (int i = 0; i < A.length; i++) {
            localSum += A[i];
            if(localSum == avg) {
                localSum = 0;
                cnt ++;
            }
            if(cnt == 2) return true;

        }
        return false;
    }

    public static void main(String[] args) {
        Prob_1020 prob = new Prob_1020();
        AssertUtils.assertTrue(prob.canThreePartsEqualSum(new int[] {0,2,1,-6,6,-7,9,1,2,0,1}));
        AssertUtils.assertFalse(prob.canThreePartsEqualSum(new int[] { 0,2,1,-6,6,7,9,-1,2,0,1}));
        AssertUtils.assertTrue(prob.canThreePartsEqualSum(new int[] {3,3,6,5,-2,2,5,1,-9,4}));
    }
}
