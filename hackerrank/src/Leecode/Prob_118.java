package Leecode;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class Prob_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> numList = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> nums = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if(j == 1 || j == i) {
                    nums.add(1);
                }else {
                    nums.add(numList.get(i - 2).get(j - 2) + numList.get(i - 2).get(j - 1));
                }
            }

            numList.add(nums);
        }

        return numList;
    }

    public static void main(String[] args) {
        Prob_118 prob = new Prob_118();
        PrintUtils.printIntListList(prob.generate(0));
        System.out.println();

        PrintUtils.printIntListList(prob.generate(1));
        System.out.println();
        PrintUtils.printIntListList(prob.generate(2));
        System.out.println();
        PrintUtils.printIntListList(prob.generate(3));
        System.out.println();
        PrintUtils.printIntListList(prob.generate(4));
        System.out.println();
        PrintUtils.printIntListList(prob.generate(5));
    }
}
