package Leecode.contest185;

import java.util.ArrayList;
import java.util.List;

public class Prob1 {
    public String reformat(String s) {
        List<Character> charList = new ArrayList<>();
        List<Character> numList = new ArrayList<>();

        for(Character ch : s.toCharArray()) {
            if(Character.isAlphabetic(ch)) {
                charList.add(ch);
            } else {
                numList.add(ch);
            }
        }
        if(Math.abs(charList.size() - numList.size()) > 1) return "";

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (i = 0; i < numList.size() && i < charList.size(); i++) {
            sb.append(charList.get(i)).append(numList.get(i));
        }

        if(i < numList.size() ) {
            sb.insert(0, numList.get(numList.size() - 1));
        }

        if (i < charList.size()) {
            sb.append(charList.get(charList.size()-1));
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        Prob1 prob1 = new Prob1();
        System.out.println(prob1.reformat("a0b1c2"));
        System.out.println(prob1.reformat("leetcode"));
        System.out.println(prob1.reformat("1229857369"));
        System.out.println(prob1.reformat("covid2019"));
        System.out.println(prob1.reformat("ab123"));
        System.out.println(prob1.reformat("abcd123"));
    }
}
