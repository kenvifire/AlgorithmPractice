package Leecode;

import java.util.HashMap;
import java.util.Map;

public class Prob_1007 {
    public int minDominoRotations(int[] A, int[] B) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for(int a : A) {
            int val = cntMap.getOrDefault(a, 0);
            cntMap.put(a, val + 1);
        }

        for (int b : B) {
            int val = cntMap.getOrDefault(b, 0);
            cntMap.put(b, val + 1);
        }

        int max = Integer.MIN_VALUE;
        int key = -1;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                key = entry.getKey();
            }
        }


        int cnt = 0;
        int cntA = 0;
        int cntB = 0;
        for (int i = 0; i < A.length; i++ ) {
            if(A[i] == key || B[i] == key) cnt++;
            if(A[i] == key) cntA++;
            if(B[i] == key) cntB++;
        }

        return cnt < A.length ? -1 : A.length - Math.max(cntA, cntB);
    }
}
