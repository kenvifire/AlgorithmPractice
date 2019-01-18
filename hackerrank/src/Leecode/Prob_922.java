package Leecode;

public class Prob_922 {
    public int[] sortArrayByParityII(int[] A) {
        int[] B = new int[A.length];

        int idxEvn = 0;
        int idxOdd = 1;

        int idx = 0;
        while (idx < A.length) {
            if(A[idx] % 2 == 1) {
               B[idxOdd] = A[idx];
               idxOdd += 2;
            } else {
               B[idxEvn] = A[idx];
               idxEvn += 2;
            }

            idx++;
        }

        return B;

    }


}
