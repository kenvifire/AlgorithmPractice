package algo.hackrank.algo.strings;

import lib.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
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
            Iterator<Integer> iterator = valueMap.keySet().iterator();
            int first_key = iterator.next();
            int second_key = iterator.next();
            int first_value = valueMap.get(first_key);
            int second_value = valueMap.get(second_key);


            if(first_value == 1 && ((first_key - second_key) == 1 || first_key == 1) ) return "YES";
            if(second_value == 1 && ((second_key - first_key) == 1 || second_key ==1) ) return "YES";

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
