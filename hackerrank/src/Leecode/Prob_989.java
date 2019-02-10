package Leecode;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class Prob_989 {
    public List<Integer> addToArrayForm(int[] A, int K) {

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


        List<Integer> reverse = new ArrayList<>();
        for (int i = result.size() - 1; i>=0; i--) {
           reverse.add(result.get(i)) ;
        }

        return reverse;
    }

    public static void main(String[] args) {
        Prob_989 prob = new Prob_989();
        PrintUtils.printIntList(prob.addToArrayForm(new int[] {1,2,0,0}, 34));
        PrintUtils.printIntList(prob.addToArrayForm(new int[] {2,7,4}, 181));
        PrintUtils.printIntList(prob.addToArrayForm(new int[] {2,1,5}, 806));
        PrintUtils.printIntList(prob.addToArrayForm(new int[] {9,9,9,9,9,9,9,9,9,9}, 1));
        PrintUtils.printIntList(prob.addToArrayForm(new int[] {0}, 23));
    }
}
