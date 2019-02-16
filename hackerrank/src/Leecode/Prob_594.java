package Leecode;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Prob_594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();

        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        int max = 0;

        for (Integer num : cntMap.keySet()) {
            if(cntMap.containsKey(num + 1) && (cntMap.get(num) + cntMap.get(num + 1) > max)) {
                max = cntMap.get(num) + cntMap.get(num + 1);
            }

            if(cntMap.containsKey(num - 1) && (cntMap.get(num) + cntMap.get(num - 1) > max)) {
                max = cntMap.get(num - 1) + cntMap.get(num);
            }
        }

        return max;

    }
}
