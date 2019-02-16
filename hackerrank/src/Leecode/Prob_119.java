package Leecode;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class Prob_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        for (int n = 0; n <= rowIndex; n++) {
            long cNk = 1;

            for (int k = 0; k <=n; k++) {
                if(n == rowIndex ) {
                    result.add((int)cNk);
                }
                cNk = cNk * (n - k) / (k+1);

            }


        }
        return result;
    }



    public static void main(String[] args) {
        Prob_119 prob = new Prob_119();
        PrintUtils.printIntList(prob.getRow(0));
        System.out.println();

        PrintUtils.printIntList(prob.getRow(1));
        System.out.println();
        PrintUtils.printIntList(prob.getRow(2));
        System.out.println();
        PrintUtils.printIntList(prob.getRow(3));
        System.out.println();
        PrintUtils.printIntList(prob.getRow(4));
        System.out.println();
        PrintUtils.printIntList(prob.getRow(5));
        PrintUtils.printIntList(prob.getRow(30));
    }
}
