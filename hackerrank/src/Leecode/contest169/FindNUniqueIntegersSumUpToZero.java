package Leecode.contest169;

import utils.PrintUtils;

public class FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        int[] array = new int[n];
        int start = 0;
        if(n % 2 != 0) {
            array[0] = 0;
            start = 1;
        }

        int x = 1;
        for (int i = start; i < n; i+=2) {
            array[i] = x;
            array[i+1] = -x;
            x++;
        }
        return array;

    }

    public static void main(String[] args) {
        for(int i = 0 ; i < 10; i++) {
            PrintUtils.printArray(new FindNUniqueIntegersSumUpToZero().sumZero(i));
        }
    }
}
