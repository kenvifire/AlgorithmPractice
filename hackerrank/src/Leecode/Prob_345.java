package Leecode;

import utils.AssertUtils;

import java.util.HashSet;
import java.util.Set;

public class Prob_345 {
    Set<Character> vowels = new HashSet<>();

    public Prob_345() {
        vowels.add('a') ;
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');
    }
    public String reverseVowels(String s) {

        StringBuilder sb = new StringBuilder(s);
        int left = 0, right = s.length() - 1;

        while (left <= right) {
            char leftCh = s.charAt(left) ;
            char rightCh = s.charAt(right);

            if(vowels.contains(leftCh) && vowels.contains(rightCh)) {
                sb.setCharAt(left, rightCh);
                sb.setCharAt(right, leftCh);
                left ++;
                right--;
            } else if (!vowels.contains(leftCh)){
               left++;
            } else {
                right--;
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Prob_345 prob = new Prob_345();

        AssertUtils.equals("",prob.reverseVowels(""));
        AssertUtils.equals("abc",prob.reverseVowels("abc"));
        AssertUtils.equals("abe",prob.reverseVowels("eba"));
        AssertUtils.equals("aee",prob.reverseVowels("eea"));
        AssertUtils.equals("uoiea",prob.reverseVowels("aeiou"));
        AssertUtils.equals("xxxxxxxxxxxa",prob.reverseVowels("xxxxxxxxxxxa"));
        AssertUtils.equals("axxxxxxxxxxx",prob.reverseVowels("axxxxxxxxxxx"));
        AssertUtils.equals("axxxxxxxxxxxe",prob.reverseVowels("exxxxxxxxxxxa"));
    }
}
