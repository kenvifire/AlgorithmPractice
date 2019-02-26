package Leecode;

import utils.AssertUtils;

public class Prob_941 {
    public boolean validMountainArray(int[] A) {
        if(A== null || A.length < 3) return false;

        int i = 1;
        while (i < A.length && A[i] > A[i-1]) i++;

        i--;

        int j = A.length - 1;
        while (j >= i && j > 1 && A[j] < A[j-1]) j--;

        return i==j && (i> 0 && i < A.length - 1);
    }

    public static void main(String[] args) {
        Prob_941 prob = new Prob_941();

        AssertUtils.assertFalse(prob.validMountainArray(new int[]{1}));
        AssertUtils.assertFalse(prob.validMountainArray(new int[]{1, 2}));
        AssertUtils.assertFalse(prob.validMountainArray(new int[]{1, 2, 3}));
        AssertUtils.assertTrue(prob.validMountainArray(new int[]{1, 2, 3, 2}));

        AssertUtils.assertTrue(prob.validMountainArray(new int[]{1, 2, 1}));
        AssertUtils.assertFalse(prob.validMountainArray(new int[]{1, 2, 1, 1}));
        AssertUtils.assertFalse(prob.validMountainArray(new int[]{1, 1, 1, 1}));
        AssertUtils.assertFalse(prob.validMountainArray(new int[]{9,8,7,6,5,4,3,2,1,0}));
        AssertUtils.assertFalse(prob.validMountainArray(new int[]{0,1,2,3,4,5,6,7,8}));
    }

}
