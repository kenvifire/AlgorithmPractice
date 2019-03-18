package Leecode;

import org.omg.PortableInterceptor.INACTIVE;
import utils.AssertUtils;

public class Prob_835 {
    public int largestOverlap(int[][] A, int[][] B) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j<= B.length; j++) {
                int curr = overlap(A, B, i, j);
                if(curr > max) {
                    max = curr;
                }
            }
        }
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j<= B.length; j++) {
                int curr = overlap(B, A, i, j);
                if(curr > max) {
                    max = curr;
                }
            }
        }
        return max;
    }

    private int overlap(int[][] A, int[][] B, int x, int y) {
        int ax = A.length - x;
        int ay = A[0].length - y;
        int cnt = 0;
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++) {
                if(A[ax + i][ay + j] == 1 && B[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Prob_835 prob = new Prob_835();
        AssertUtils.equals(3, prob.largestOverlap(new int[][]{{1,1,0}, {0,1,0}, {0,1,0}},
                new int[][]{{0,0,0}, {0,1,1}, {0,0,1}}));
    }

}
