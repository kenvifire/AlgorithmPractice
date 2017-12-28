package algo.hackrank.algo.strings;

import lib.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kenvi on 2017/12/28.
 */
public class SherlockAndTheValidString {
    static String isValid(String s){
        // Complete this function
        Map<Character, Integer> charMap = StringUtils.str2CharMap(s);

        Map<Integer, Integer> valueMap = new HashMap<>();

        for (Integer key : charMap.values()) {
           if(valueMap.containsKey(key)) {
               valueMap.put(key, valueMap.get(key) + 1);
           }else {
               valueMap.put(key, 1);
           }
        }

        int size = valueMap.size();
        if(size <=1 ) {
            return "YES";
        }else if(valueMap.size() == 2) {
            int first_key = valueMap.keySet().iterator().next();
            int second_key = valueMap.keySet().iterator().next();


            if(valueMap.get(first_key) == 1 && (second_key - first_key) == 1) return "YES";
            if(valueMap.get(second_key) == 1 && (first_key - second_key) == 1) return "YES";

            return "NO";
        }else {
            return "NO";
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
