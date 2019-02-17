package Leecode;

import java.util.ArrayList;
import java.util.List;

public class Prob_66 {
    public int[] plusOne(int[] digits) {
        int[] A = digits;
        int K = 1;
        List<Integer> result = new ArrayList<>();

        int carry = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int a = A[i];
            int current = K % 10 + carry + a;
            K /= 10;
            if(current >= 10) {
                current -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            result.add(current);
        }

        while (K > 0) {
            int current = K % 10 + carry;
            K/=10;
            if(current >= 10) {
                current -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result.add(current);
        }

        if(carry > 0) result.add(carry);

        int[] resultArr = new int[result.size()];
        for (int i = result.size() - 1; i>=0; i--) {
            resultArr[result.size() - i - 1] = result.get(i);
        }
        return resultArr;
    }
}
