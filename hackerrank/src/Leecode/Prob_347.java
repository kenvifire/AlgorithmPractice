package Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob_347 {
    static class Point implements Comparable<Point> {
        int val;
        int freq;
        public Point(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
        @Override
        public int compareTo(Point that) {
            return that.freq - this.freq;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();

        for (int num : nums) {
            int val = cntMap.getOrDefault(num, 0);
            cntMap.put(num, val + 1);
        }

        List<Point> pointList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            pointList.add(new Point(entry.getKey(), entry.getValue()));

        }

        Collections.sort(pointList);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pointList.get(i).val);
        }
        return result;

    }
}
