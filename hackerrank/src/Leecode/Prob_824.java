package Leecode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Prob_824 {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.addAll(Arrays.asList('a','e','i','o','u'));
        vowelSet.addAll(Arrays.asList('A','E','I','O','U'));

        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            Character ch = word.charAt(0);

            if(vowelSet.contains(ch)) {
                sb.append(word).append("ma");
            } else {
                sb.append(word, 1, word.length()).append(ch).append("ma");
            }

            for (int i = 0; i <= index; i++) {
                sb.append('a');
            }
            index++;

            sb.append(' ');

        }
        return sb.subSequence(0, sb.length() - 1).toString();



    }

    public static void main(String[] args) {
        new Prob_824().toGoatLatin("I speak Goat Latin");
    }
}
