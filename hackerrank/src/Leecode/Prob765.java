package Leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/couples-holding-hands/
 */
public class Prob765 {
    public int minSwapsCouples(int[] row) {
        Map<Integer, Integer> seatMap = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < row.length; i++) {
            seatMap.put(row[i], i);
        }

        for(int i = 0; i < row.length; i+=2) {
            int curr = row[i];
            int next = row[i + 1];
            int actualNext = curr % 2 == 0 ? curr + 1 : curr - 1;
            //System.out.printf("current:%d, next:%d, actualNext:%d\n", curr, next, actualNext);
            if(actualNext == next) continue;

            cnt+=1;
            //swap
            swap(row, seatMap, next, actualNext);
        }
        return cnt;
    }

    private void swap(int[] row, Map<Integer, Integer> seatMap, int x, int y) {
        int temp = row[seatMap.get(x)];
        row[seatMap.get(x)] = row[seatMap.get(y)];
        row[seatMap.get(y)] = temp;
        temp = seatMap.get(x);
        seatMap.put(x, seatMap.get(y));
        seatMap.put(y, temp);
    }
}
