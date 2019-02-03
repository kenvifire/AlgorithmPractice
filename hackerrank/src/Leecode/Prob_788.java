package Leecode;

import java.util.HashSet;
import java.util.Set;

public class Prob_788 {
    private Set<Character> invalidSet = new HashSet<>();
    private Set<Character> nonSelfSet = new HashSet<>();

    public Prob_788() {
        invalidSet.add('3');
        invalidSet.add('4');
        invalidSet.add('7');
        nonSelfSet.add('2');
        nonSelfSet.add('5');
        nonSelfSet.add('6');
        nonSelfSet.add('9');

    }

    public int rotatedDigits(int N) {
        int cnt = 0;
        for (int i = 1; i<=N; i++) {
            if(isValid(String.valueOf(i))) cnt++;
        }

        return cnt;

    }

    private boolean isValid(String str) {
        boolean hasNonSelf = false;
        for (int i = 0; i < str.length(); i++) {
            if(invalidSet.contains(str.charAt(i))) return false;

            if(nonSelfSet.contains(str.charAt(i))) hasNonSelf = true;
        }
        return hasNonSelf;
    }

    public static void main(String[] args) {
        System.out.println(new Prob_788().rotatedDigits(10));
    }






}
