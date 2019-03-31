package Leecode;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String key  = new String(charArray);
            if(!result.containsKey(key)) {
                List<String> val = new ArrayList<>();
                val.add(str);
                result.put(key, val);
            } else {
                List<String> val = result.get(key);
                val.add(str);
            }
        }

        return new ArrayList<>(result.values());

    }

    public static void main(String[] args) {
        Prob_49 prob = new Prob_49();
        PrintUtils.printStringListList(prob.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
