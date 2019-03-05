package Leecode;

import utils.AssertUtils;

import java.util.HashSet;
import java.util.Set;

public class Prob_859 {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length() || A.length() < 2) return false;
        int[] diff = new int[2];
        int index =0;
        Set<Character> charSet = new HashSet<>();
        boolean dup = false;
        for (int i = 0; i < A.length(); i++) {
            if(index >= 2) return false;
            if(A.charAt(i) != B.charAt(i)) {
                diff[index] = i;
                index++;
            } else {
                if(!dup && !charSet.contains(A.charAt(i))) {
                    charSet.add(A.charAt(i));
                }else {
                    dup = true;
                }
            }

        }


        return (index == 0 && dup) || (index == 2 && A.charAt(diff[0]) == B.charAt(diff[1]) && A.charAt(diff[1]) == B.charAt(diff[0]));
    }

    public static void main(String[] args) {
        Prob_859 prob = new Prob_859();
        AssertUtils.assertTrue(prob.buddyStrings("aa", "aa"));
        AssertUtils.assertFalse(prob.buddyStrings("ab", "ab"));
        AssertUtils.assertTrue(prob.buddyStrings("ab", "ba"));
        AssertUtils.assertFalse(prob.buddyStrings("abc", "bac"));
        AssertUtils.assertFalse(prob.buddyStrings("a", "a"));
        AssertUtils.assertFalse(prob.buddyStrings("a", "ac"));
        AssertUtils.assertTrue(prob.buddyStrings("cba", "abc"));
        AssertUtils.assertTrue(prob.buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }
}
