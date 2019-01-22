package Leecode;

import utils.PrintUtils;

public class Prob_942 {
    public int[] diStringMatch(String S) {
        int left = 0, right = S.length();
        int[] array = new int[S.length()+1];

        int index = 0;
        while (left < right) {
            if (S.charAt(index) == 'I') {
                array[index] =  left;
                left++;
            } else {
                array[index] = right;
                right--;
            }
            index++;
        }
        array[S.length()] = left;

        return array;
    }

    public static void main(String[] args) {
        PrintUtils.printArray(new Prob_942().diStringMatch("IDID"));
        PrintUtils.printArray(new Prob_942().diStringMatch("IIII"));
        PrintUtils.printArray(new Prob_942().diStringMatch("DDDD"));
    }
}
