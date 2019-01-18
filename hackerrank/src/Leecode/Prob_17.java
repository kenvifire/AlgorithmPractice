package Leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob_17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        final Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        int len = 1;

        for (int i = 0; i < digits.length(); i++) {
            len *= map.get(Integer.valueOf(digits.charAt(i)+"")).length();
        }

        List<String> result = new ArrayList<>(len);

        for (int i = 0; i < len; i ++) {
            StringBuilder sb = new StringBuilder(digits);
            int j = digits.length() - 1;
            int rest = i;
            while (j >= 0) {
                int num = Integer.valueOf(digits.charAt(j)+"");
                String str = map.get(num);
                int index = rest % str.length();
                sb.setCharAt(j, str.charAt(index));

                j--;
                rest = rest/ str.length();
            }

            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Prob_17().letterCombinations("2"));
        System.out.println(new Prob_17().letterCombinations("23"));
        System.out.println(new Prob_17().letterCombinations("232"));
    }
}
