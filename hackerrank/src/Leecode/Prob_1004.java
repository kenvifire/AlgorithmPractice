package Leecode;

import utils.AssertUtils;

import java.util.ArrayList;
import java.util.List;

public class Prob_1004 {
    public int longestOnes(int[] A, int K) {
        List<Integer> numList = new ArrayList<>();

        int current = A[0];
        int len = 1;
        for (int i = 1; i < A.length; i++) {
            if(A[i] == current) {
                len ++;
            } else {
                numList.add(len * (current == 1 ? 1 : -1));
                len = 1;
                current = A[i];
            }
        }

        numList.add(len * (current == 1 ? 1 : -1));

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numList.size(); i++) {
            int left  = K;
            int value = 0;
            int j = i;
            for (; j < numList.size() && left + numList.get(j) >= 0; j++) {
                int currentValue = numList.get(j);
                if(currentValue > 0) {
                    value += currentValue;
                } else {
                    if (left + currentValue >= 0) {
                        left += currentValue;
                        value += - currentValue;
                    }
                }

            }
            int total = 0;
            if((j < numList.size() && left > 0 && numList.get(j) < 0)){
                total += - numList.get(j);
            }

            if(i > 0 && left >0 && numList.get(i-1) < 0){
                total += - numList.get(i-1);
            }
            value += Math.min(total, left);

            if(value > max) max = value;
        }

        return max;
    }

    public static void main(String[] args) {
        Prob_1004 prob = new Prob_1004();
        AssertUtils.equals(6, prob.longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2));
        AssertUtils.equals(10, prob.longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        AssertUtils.equals(25, prob.longestOnes(new int[] {1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1}, 8));
    }
}
