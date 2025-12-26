package Leecode;

import java.util.ArrayList;
import java.util.Arrays;

public class Prob219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int[][] pairs = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o2[1] - o1[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < pairs.length - 1; i++) {
            if(pairs[i][0] == pairs[i + 1][0] && Math.abs(pairs[i][1] - pairs[i + 1][1]) <= k){
                return true;
            }
        }
        return false;
    }
}
