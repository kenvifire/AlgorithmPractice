package Leecode;

import utils.AssertUtils;

public class Prob_1021 {
    static class P1 implements Comparable<P1> {
        int val;
        int pos;

        public P1(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
        @Override
        public int compareTo(P1 that) {
            return this.pos + this.val - that.pos - that.val;
        }
    }

    static class P2 implements Comparable<P2> {
        int val;
        int pos;

        public P2(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }

        @Override
        public int compareTo(P2 that) {
            return (this.val - this.pos) - (that.val - that.pos);
        }
    }


    public int maxScoreSightseeingPair(int[] A) {

        int max = Integer.MIN_VALUE;
        int maxA = A[0];
        int maxB = Integer.MIN_VALUE;
        for (int i = 1; i < A.length ; i++) {
            if(A[i] - i > maxB) {
                maxB = A[i] - i;
            }
            if(maxA + maxB > max)  {
                max = maxA + maxB;
            }

            if(A[i] + i > maxA)   {
                maxA = A[i] + i;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        Prob_1021 prob = new Prob_1021();
        AssertUtils.equals(2, prob.maxScoreSightseeingPair(new int[]{1,2}));
    }
}
