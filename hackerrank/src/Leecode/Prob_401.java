package Leecode;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob_401 {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i <=num; i++) {
            int[] hours= getHour(i);
            int[] minutes = getMinute(num - i);
            for (int h : hours) {
                for (int m : minutes) {

                    result.add(String.format("%d:%02d", h, m));
                }
            }

        }
        return result;
    }

    public int[] getHour(int num) {
        if (num == 0) return new int[]{0};
        if(num == 1) return new int[] {1,2,4,8};
        if (num == 2) return new int[]{3,5,6,9,10 };
        if(num == 3) return new int[] {7,11 };
        return new int[]{};
    }

    public int[] getMinute(int num) {
        if(num == 0) return new int[]{0};
        if(num == 1) return new int[] {1,2,4,8,16,32};
        if(num == 2) return new int[]{3,5,9,17,33,6,10,18,34,12,20,36,24,40, 48};
        if(num == 3) return new int[] {7,11,13,14,19,21,22,25,26,28,35,37,38,41,42,44,49,50,52,56};
        if (num == 4) return new int[]{15,23,27,29,30,39,43,45,46,51,53,54,57,58};
        if (num == 5) return new int[] {31,47,55,59};
        return new int[]{};

    }

    public static void main(String[] args) {
        Prob_401 prob = new Prob_401();
        PrintUtils.printStringList(prob.readBinaryWatch(0));
        PrintUtils.printStringList(prob.readBinaryWatch(1));
        PrintUtils.printStringList(prob.readBinaryWatch(2));
        PrintUtils.printStringList(prob.readBinaryWatch(20));
    }
}
