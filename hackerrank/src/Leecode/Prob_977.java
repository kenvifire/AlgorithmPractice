package Leecode;

import utils.PrintUtils;

public class Prob_977 {
    public int[] sortedSquares(int[] A) {
        if(A.length == 1) return new int[] {A[0] * A[0]};

        int middle= -1;
        for (int i = 0; i < A.length - 1; i++) {
            if(A[i] * A[i+1] <= 0) {
                middle = i;
                break;
            }
        }

        int left = middle, right = middle + 1;

        int index = 0;

        int[] squared = new int[A.length];
        while (index < A.length) {
            if (left < 0) {
                squared[index++]  = A[right] * A[right];
                right++;
                continue;
            }
            if (right >= A.length) {
                squared[index++] = A[left] * A[left];
                left--;
                continue;
            }

            if(A[right] * A[right] < A[left] * A[left]) {
                squared[index++]  = A[right] * A[right];
                right ++;
            } else {
                squared[index++] = A[left] * A[left];
                left--;
            }
        }
        return squared;

    }

    public static void main(String[] args) {
        PrintUtils.printArray(new Prob_977().sortedSquares(new int[]{-2,0}));
        PrintUtils.printArray(new Prob_977().sortedSquares(new int []{1, 2, 3}));
        PrintUtils.printArray(new Prob_977().sortedSquares(new int []{-4,-1,0,0,3,10}));
        PrintUtils.printArray(new Prob_977().sortedSquares(new int []{-7,-3,2,3,11}));
    }


}
