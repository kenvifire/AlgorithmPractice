package Leecode.contest200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob5478 {

//    public int maxSum(int[] nums1, int[] nums2) {
//        Map<Integer, List<Integer>> numListMap = new HashMap<>();
//
//        for (int i = 0; i < nums1.length; i++) {
//            int num = nums1[i];
//            List<Integer> list = numListMap.getOrDefault(num, new ArrayList<>());
//            list.add(num);
//            numListMap.put(num, list);
//        }
//
//        for (int i = 0; i < nums2.length; i++) {
//            int num = nums2[i];
//            List<Integer> list = numListMap.getOrDefault(num, new ArrayList<>());
//            list.add(num);
//            numListMap.put(num, list);
//        }
//
//        int[] dist = new int[numListMap.keySet().size()];
//
//        Arrays.fill(dist, Integer.MIN_VALUE);
//
//        List<Integer> nums = new ArrayList<>(numListMap.keySet());
//        Collections.sort(nums, Comparator.reverseOrder());
//
//        for(int num : nums) {
//
//
//        }
//
//
//
//
//
//    }
}
