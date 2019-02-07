package Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prob_598 {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length == 0) return m*n;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for(int[] op : ops) {
            if(op[0] < minX) minX = op[0];

            if(op[1] < minY) minY = op[1];
        }

        return minX * minY;


    }
}
