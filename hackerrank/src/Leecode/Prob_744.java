package Leecode;

import java.util.Arrays;

public class Prob_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target == 'z') {
            target = 'a';
        } else {
            target = (char) (target + 1);
        }

        int index = Arrays.binarySearch(letters, target);
        if(index < 0 ) index = - (index + 1);
        index = index % letters.length;

        return letters[index];

    }
}
