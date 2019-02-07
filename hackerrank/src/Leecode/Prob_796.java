package Leecode;

import java.util.Arrays;

public class Prob_796 {
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) return false;
        if(A.equals(B)) return true;

        char[] aArray = A.toCharArray();
        char[] bArray = B.toCharArray();
        for (int i = 1; i < A.length(); i++){
            if(charArrayEqals(aArray, rotateString(bArray)))  return true;
        }

        return false;

    }

    private boolean charArrayEqals(char[] A, char[] B) {
        return Arrays.equals(A, B);
    }

    private char[] rotateString(char[] str) {
        char temp = str[0];

        for (int i = 1; i < str.length; i++) {
            str[i-1] = str[i];
        }
        str[str.length - 1] = temp;
        return str;
    }

    public static void main(String[] args) {
        System.out.println(new Prob_796().rotateString("abcde", "cdeab"));
        System.out.println(new Prob_796().rotateString("abcd", "abcd"));
        System.out.println(new Prob_796().rotateString("abe", "cdeab"));
        System.out.println(new Prob_796().rotateString("abc", "abcd"));
        System.out.println(new Prob_796().rotateString("abcde", "abced"));
    }
}
