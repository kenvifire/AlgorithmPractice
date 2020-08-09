package Leecode.contest201;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prob5471 {
    static class Interval implements Comparable<Interval>{
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        int start, end;

        @Override
        public int compareTo(Interval o) {
            return this.end - o.end;
        }

        public boolean isNotOverlap(Interval other) {
            return this.end < other.start || this.start > other.end;
        }
    }
    public int maxNonOverlapping(int[] nums, int target) {

        List<Interval> intervalList = new ArrayList<>();
        int len = nums.length;
        for(int i = 0; i < len ;i++ ){
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if(sum == target) {
                   intervalList.add(new Interval(i, j));
                }
            }
        }

        if(intervalList.size() == 0) return 0;
        Collections.sort(intervalList);


        List<Interval> results = new ArrayList<>();

        results.add(intervalList.get(0));
        for(int i = 1; i < intervalList.size(); i++) {
            if(intervalList.get(i).isNotOverlap(results.get(results.size() - 1))) {
                results.add(intervalList.get(i));
            }
        }
        return results.size();
    }

    public static void main(String[] args) {
        Prob5471 prob5471 = new Prob5471();
        prob5471.maxNonOverlapping(new int[] {-1,-2,8,-3,8,-5,5,-4,5,4,1}, 5);
    }
}
