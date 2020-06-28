package Leecode.contest195;

import java.util.HashMap;
import java.util.Map;

public class Prob5449 {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainSet = new HashMap<>();

        for(int a : arr) {
            int r = a % k;
            if(r < 0) r += k;
            int cnt = remainSet.getOrDefault(r, 0);
            remainSet.put(r, cnt + 1);
        }

        for(int r : remainSet.keySet()) {
            if(r == 0) {
                if(remainSet.get(r) %2 != 0) {
                    return false;
                }else {
                    continue;
                }
            }
            int r2 = k - r;
            if(!(remainSet.getOrDefault(r2, 0).equals(  remainSet.getOrDefault(r, 0)))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Prob5449 prob = new Prob5449();
        prob.canArrange(new int[] {-10, 10}, 2);
    }

}
