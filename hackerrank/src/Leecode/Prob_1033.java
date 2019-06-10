package Leecode;

import java.util.Arrays;

public class Prob_1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] array = new int[3];
        array[0] = a;
        array[1] = b;
        array[2] = c;
        Arrays.sort(array);
        int x = array[0], y = array[1], z = array[2];

        int[] result = new int[2];
        if(Math.abs(x - y) <= 1 && Math.abs(y - z) <= 1 && Math.abs(x -z ) <= 1) {
            result[0] = 0;
            result[1] = 0;
        } else {
            result[0] = ((y - x > 1) ? 1 : 0) + ((z - y > 1) ? 1 : 0);
            result[1] =  z + y - 2 * x - 2 - 1;
        }
        return result;
    }
}
