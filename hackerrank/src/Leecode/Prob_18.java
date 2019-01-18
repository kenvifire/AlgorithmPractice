package Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Prob_18 {
    static class Quadruplet {
        Integer[] tripple = new Integer[4];

        public Quadruplet(int a, int b, int c, int d) {
            tripple[0] = a;
            tripple[1] = b;
            tripple[2] = c;
            tripple[3] = d;
            Arrays.sort(tripple);
        }

        @Override
        public boolean equals(Object obj) {
            Quadruplet other = (Quadruplet)obj;

            return this.tripple[0].intValue() == other.tripple[0].intValue()
                    && this.tripple[1].intValue() == other.tripple[1].intValue()
                    && this.tripple[2].intValue() == other.tripple[2].intValue()
                    && this.tripple[3].intValue() == other.tripple[3].intValue();
        }

        @Override
        public int hashCode() {
            return tripple[0] * 7 + tripple[1]* 13 + tripple[2] * 59 + tripple[3] * 67;
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        final Map<Integer, Integer> numMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], numMap.get(nums[i]) == null ?  1 : numMap.get(nums[i]) + 1);
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Set<Quadruplet> quadrupletSet = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 1 && nums[i] == nums[i - 1] && nums[i-1] == nums[i-2]) {
                        continue;
            }
            int a = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int b = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int c = nums[k];
                    int d = target - a - b - c;
                    int count = numMap.get(d) == null ? 0 : numMap.get(d);
                    int countA = 1 + (b == a ? 1 : 0) + (c == a ? 1 : 0) + (d == a ? 1 : 0);
                    int countB = 1 + (a == b ? 1 : 0) + (c == b ? 1 : 0) + (d == b ? 1 : 0);
                    int countC = 1 + (a == c ? 1 : 0) + (b == c ? 1 : 0) + (d == c ? 1 : 0);
                    int countD = 1 + (a == d ? 1 : 0) + (b == d ? 1 : 0) + (c == d ? 1 : 0);

                    if (count >= countC && numMap.get(b) >= countB && numMap.get(a) >= countA && numMap.get(d) >= countD) {
                        Quadruplet quadruplet = new Quadruplet(a, b, c, d);
                        if (!quadrupletSet.contains(quadruplet)) {
                            resultList.add(Arrays.asList(quadruplet.tripple));
                            quadrupletSet.add(quadruplet);
                        }
                    }
                }
            }
        }

        return resultList;

    }

    public static void main(String[] args) {
        System.out.println(new Prob_18().fourSum(new int [] {1, 0, -1, 0, -2, 2}, 0));
    }
}
