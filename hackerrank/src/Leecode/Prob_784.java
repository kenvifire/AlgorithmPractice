package Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prob_784 {
    public List<String> letterCasePermutation(String S) {

        if(S.length() == 0)  return Arrays.asList("");

        List<String> restPerm = letterCasePermutation(S.substring(1, S.length()));
        List<String> result = new ArrayList<>();
        if (Character.isAlphabetic(S.charAt(0))) {
            for (String str : restPerm) {
                result.add(Character.toLowerCase(S.charAt(0)) + str);
                result.add(Character.toUpperCase(S.charAt(0)) + str);
            }
        } else {
            for (String str : restPerm) {
                result.add(S.charAt(0) + str);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Prob_784().letterCasePermutation("3z4"));
        System.out.println(new Prob_784().letterCasePermutation("12345"));
    }
}
