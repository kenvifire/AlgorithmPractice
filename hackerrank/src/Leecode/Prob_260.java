package Leecode;


import java.util.HashMap;
import java.util.Map;

public class Prob_260 {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(int num : nums) {
            int val = map.getOrDefault(num, 0);
            map.put(num, val+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) result[idx++] = entry.getKey();
        }

        return result;
    }
}
