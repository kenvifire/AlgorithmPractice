package Leecode;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class Prob_821 {

    public int[] shortestToChar(String S, char C) {
        int[] disArray = new int[S.length()];
        List<Integer> charList = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == C) charList.add(i);
        }

        int index = 0;

        int i = 0;
        while (index < charList.size() && i < S.length()) {
            int left = charList.get(index);
            int right = index < charList.size() - 1 ? charList.get(index + 1)  : Integer.MAX_VALUE;
           if(i <= left) {
               disArray[i] = Math.abs(i - left);
               i++;
           } else {
               if(right < S.length()) {
                   disArray[i]= Math.min(Math.abs(i - left), Math.abs(i - right));
                   i++;
                    if(i > right) {
                        index++;
                    }

               } else {
                   disArray[i] = Math.abs(i - left);
                   i++;
               }
           }
        }

        return disArray;


    }

    public static void main(String[] args) {
        PrintUtils.printArray(new Prob_821().shortestToChar("loveleetcode", 'e'));
        PrintUtils.printArray(new Prob_821().shortestToChar("e", 'e'));
        PrintUtils.printArray(new Prob_821().shortestToChar("eee", 'e'));
        PrintUtils.printArray(new Prob_821().shortestToChar("lllle", 'e'));
        PrintUtils.printArray(new Prob_821().shortestToChar("elll", 'e'));
    }

}
