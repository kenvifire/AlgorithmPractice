package Leecode;

public class Prob_896 {
    public boolean isMonotonic(int[] A) {
        if(A.length <= 2) return true;

        int start = 0;
        int step = 1;

        if(A[0] > A[A.length - 1]) {
            start = A.length - 1;
            step = -1;
        }

        for (int i = start; i >= 0 && i < A.length; i+=step ) {
            if(i+step >= 0 && i+step < A.length) {
                if (A[i] > A[i + step]) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Prob_896().isMonotonic(new int[]{0}));
        System.out.println(new Prob_896().isMonotonic(new int[]{0, 0}));
        System.out.println(new Prob_896().isMonotonic(new int[]{0, 0, 0}));
        System.out.println(new Prob_896().isMonotonic(new int[]{0, 1, 0}));
        System.out.println(new Prob_896().isMonotonic(new int[]{1, 1, 0}));
        System.out.println(new Prob_896().isMonotonic(new int[]{1, 1, 1}));
        System.out.println(new Prob_896().isMonotonic(new int[]{1, 2, 1}));
        System.out.println(new Prob_896().isMonotonic(new int[]{1, 2, 3}));
        System.out.println(new Prob_896().isMonotonic(new int[]{1, 1, 3}));
    }
}
