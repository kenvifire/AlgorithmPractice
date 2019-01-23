package Leecode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Prob_884 {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> set = new HashMap<>();

        for (String strA : A.split(" ")) {
            if(set.containsKey(strA)) {
                set.put(strA, set.get(strA) + 1);
            }else {
                set.put(strA, 1);
            }
        }

        for (String strB : B.split(" ")) {
            if(set.containsKey(strB)) {
                set.put(strB, set.get(strB) + 1);
            }else {
                set.put(strB, 1);
            }
        }

        List<String> strList = set.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());


        String[] strArray = strList.toArray(new String[strList.size()]);
        return strArray;

    }
}
