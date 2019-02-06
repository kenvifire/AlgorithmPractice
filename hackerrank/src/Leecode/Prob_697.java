package Leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prob_697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        int max = 0;
        for (int num : nums) {
            int origin = numsMap.getOrDefault(num, 0);
            numsMap.put(num, origin+1);
            if(origin + 1 > max) {
                max = origin + 1;
            }
        }

        Map<Integer,Integer> maxSet = new HashMap<>();

        int index = 0;
        for (Map.Entry<Integer, Integer> entry : numsMap.entrySet()) {
            if(entry.getValue() == max)  maxSet.put(entry.getKey(), index++);
        }

        int[] start = new int[maxSet.size()];
        for (int i = 0; i < start.length; i++) start[i] = -1;
        int[] end = new int[maxSet.size()];

        for (int i = 0; i < nums.length; i++) {
            if (maxSet.containsKey(nums[i])) {
                int idx = maxSet.get(nums[i]);
                if (start[idx] == -1) {
                    start[idx] = i;
                }
                end[idx] = i;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < maxSet.size(); i++) {
            if(end[i] - start[i] + 1 < min) min = end[i] - start[i] + 1;
        }

        return min;


    }

    public static void main(String[] args) {
        System.out.println(new Prob_697().findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(new Prob_697().findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
    }

}
