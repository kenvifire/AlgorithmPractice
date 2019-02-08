package Leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob_599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++){
            map2.put(list2[i], i);
        }
        int min = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            if(map2.containsKey(key)) {
                int sum = map1.get(key) + map2.get(key);

                if(sum < min) {
                    min = sum;
                    result = new ArrayList<>();
                    result.add(key);
                } else if(sum == min) {
                    result.add(key);
                }
            }
        }

        String[] resultArray = new String[result.size()];
        return result.toArray(resultArray);

    }
}
