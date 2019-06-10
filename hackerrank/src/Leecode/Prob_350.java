package Leecode;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Prob_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];

        Map<Integer, Integer> cntMap1 = new HashMap<>();

        //O(n)
        for(int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            int value = cntMap1.getOrDefault(key, 0);
            cntMap1.put(key, value+1);
        }

        Map<Integer, Integer> cntMap2 = new HashMap<>();

        //O(n)
        for(int i = 0; i < nums2.length; i++) {
            int key = nums2[i];
            int value = cntMap2.getOrDefault(key, 0);
            cntMap2.put(key, value+1);
        }

        List<Integer> resultList = new ArrayList<>();
        //O(n);
        for (Map.Entry<Integer, Integer> entry1 : cntMap1.entrySet()) {
            Integer cnt2 = cntMap2.get(entry1.getKey());
            if(cnt2 != null) {
                for (int i = 0; i < Math.min(entry1.getValue(), cnt2); i++) {
                   resultList.add(entry1.getKey());
                }
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) result[i] = resultList.get(i);

        return result;


    }
}
