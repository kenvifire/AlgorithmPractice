package Leecode;

import java.util.HashMap;
import java.util.Map;

public class Prob_454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Long, Integer> cntMapAB = toMap(A, B);
        Map<Long, Integer> cntMapCD = toMap(C, D);

        int cnt = 0;
        for (Map.Entry<Long, Integer> entryAB : cntMapAB.entrySet()) {
            if(cntMapCD.containsKey(-entryAB.getKey())) {
                cnt += entryAB.getValue() * cntMapCD.get(-entryAB.getKey());
            }
        }
        return cnt;
    }

    private Map<Long, Integer> toMap(int[] A, int[] B) {

        Map<Long, Integer> cntAB = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                long sum = A[i] + B[j];
                int val = cntAB.getOrDefault(sum, 0);
                cntAB.put(sum, val + 1);
            }
        }
        return cntAB;
    }
}
