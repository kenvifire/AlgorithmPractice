package Leecode;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class Prob_1029 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();

        long sum = 0;

        int i = 0;
        for (int j = 0; j < A.length; j++) {
            int a = A[j];
            sum = sum << 1;
            if(a == 1) {
                sum += 1 ;
            }

            if(sum % 5 == 0) {
                result.add(true);
            } else {
                result.add(false);
            }

            i++;
            sum = sum % 5;
        }

        return result;

    }

    public static void main(String[] args) {
        Prob_1029 prob = new Prob_1029();
        List<Boolean> result1 = prob.prefixesDivBy5(new int[]{0,1,1});
        List<Boolean> result2 = prob.prefixesDivBy5(new int[]{1,1,1});
        List<Boolean> result3 = prob.prefixesDivBy5(new int[]{0,1,1,1,1,1});
        List<Boolean> result4 = prob.prefixesDivBy5(new int[]{1,1,1,0,1});
        List<Boolean> result5 = prob.prefixesDivBy5(new int[]{1,1,0,0,0,1,0,0,1});

    }
}
