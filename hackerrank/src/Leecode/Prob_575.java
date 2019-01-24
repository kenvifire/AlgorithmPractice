package Leecode;

import java.util.HashSet;
import java.util.Set;

public class Prob_575 {
    public int distributeCandies(int[] candies) {
        Set<Integer> numSet = new HashSet<>();

        for (int c : candies) {
            numSet.add(c);
        }

        return numSet.size() < candies.length / 2 ? numSet.size() : candies.length / 2;
    }

}
