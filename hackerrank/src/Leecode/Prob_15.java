package Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Prob_15 {
    static class Triple {
        Integer[] tripple = new Integer[3];

        public Triple(int a, int b, int c) {
            tripple[0] = a;
            tripple[1] = b;
            tripple[2] = c;
            Arrays.sort(tripple);
        }

        @Override
        public boolean equals(Object obj) {
            Triple other = (Triple)obj;

            return this.tripple[0].intValue() == other.tripple[0].intValue()
                    && this.tripple[1].intValue() == other.tripple[1].intValue()
                    && this.tripple[2].intValue() == other.tripple[2].intValue();
        }

        @Override
        public int hashCode() {
            return tripple[0] * 7 + tripple[1]* 13 + tripple[2] * 59;
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        final Map<Integer, Integer> numMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], numMap.get(nums[i]) == null ?  1 : numMap.get(nums[i]) + 1);
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Set<Triple> tripleSet = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                int c = 0 - a - b;
                int count = numMap.get(c) == null ? 0 : numMap.get(c);
                int countA = 1 + (b == a? 1 : 0) + ( c == a ? 1 :0);
                int countB = 1 + (a == b? 1 : 0) + ( c == b ? 1 :0);
                int countC = 1 + (a == c? 1 : 0) + ( b == c ? 1 :0);

                if (count >= countC && numMap.get(b) >= countB && numMap.get(a) >= countA) {
                    Triple triple = new Triple(a, b, c);
                    if (!tripleSet.contains(triple)) {
                        resultList.add(Arrays.asList(triple.tripple));
                        tripleSet.add(triple);
                    }
                }
            }
        }

        return resultList;

    }
}
