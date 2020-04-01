package Leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/sort-integers-by-the-power-value/
 */
public class Prob1387 {
    Map<Integer, Integer> mem;
    public int getKth(int lo, int hi, int k) {
        mem = new HashMap<>();
        int[] result = new int[hi - lo +1];
        mem.put(1, 0);
        mem.put(2, 1);

        for(int i = lo; i <= hi; i++) {
            result[i - lo] = dp(i);
        }

        int[] sortedIndex = IntStream.range(0, result.length)
            .boxed().sorted((i,j) -> {
                if(result[i] != result[j]) {
                    return result[i] - result[j];
                } else {
                    return i - j;
                }
            }).mapToInt(e -> e).toArray();

        return lo + sortedIndex[k - 1];

    }

    int dp(int curr) {
        if(mem.get(curr) != null) return mem.get(curr);
        if(curr % 2 == 0) {
            int val = dp(curr / 2) + 1;
            mem.put(curr, val);
            return val;
        }
        else {
            int val = dp(3 * curr + 1) + 1;
            mem.put(curr, val);
            return val;
        }

    }
}
