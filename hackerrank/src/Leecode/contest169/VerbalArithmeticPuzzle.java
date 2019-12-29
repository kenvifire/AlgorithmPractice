package Leecode.contest169;


import utils.PrintUtils;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VerbalArithmeticPuzzle {

    boolean solvable = false;
    BitSet numSet;
    boolean[] canZero;
    int[] leftCharCnt;
    int[] rightCharCnt;
    public boolean isSolvable(String[] words, String result) {
        Set<Character> charset = new HashSet<>();
        numSet = new BitSet(10);
        canZero = new boolean[26];
        leftCharCnt = new int[26];
        rightCharCnt = new int[26];

        for (int i =0; i < 26; i++) canZero[i] = true;

        int weight = 1;
        for (String word : words) {
            weight = (int)Math.pow(10, word.length() - 1);
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(i == 0) {
                    canZero[ch - 'A'] = false;
                }
                charset.add(ch);
                leftCharCnt[ch - 'A'] += weight;
                weight /= 10;
            }
        }



        weight = (int)Math.pow(10, result.length() - 1);
        for (int i = 0; i < result.length(); i++) {
            char ch = result.charAt(i);
            if(i == 0) {
                canZero[ch - 'A'] = false;
            }
            charset.add(ch);
            rightCharCnt[ch - 'A'] += weight;
            weight /= 10;
        }

//        PrintUtils.printArray(leftCharCnt);
//        PrintUtils.printArray(rightCharCnt);

        if(charset.size() > 10) return false;
        List<Character> charList = new ArrayList<>();
        charList.addAll(charset);

        solvable = false;

        backtrack(charList, 0, 0, 0);
        return solvable;


    }


    public void backtrack(List<Character> charList, int pos, int left, int right) {
        if(solvable) return;
        if(charList.size()  == pos) {
            if(left == right) {
                solvable = true;
                return;
            } else {
                return;
            }
        }

        for (int i = 0; i <= 9; i++) {
            if(i == 0 && !canZero[charList.get(pos) - 'A']) continue;
            if(!numSet.get(i)) {
                numSet.set(i, true);
                backtrack(charList, pos + 1, left+ leftCharCnt[charList.get(pos) - 'A'] *i,
                        right+ rightCharCnt[charList.get(pos) - 'A'] * i);
                numSet.set(i, false);
            }
        }

    }

//    boolean check() {
//        int result = getValue(resulgG);
//        if(result < 0) return false;
//        for (String word: wordG) {
//            int value = getValue(word);
//            if(value < 0) return false;
//            result -= getValue(word);
//
//            if(result < 0) return false;
//        }
//
//        return result == 0;
//    }
//
//    private int getValue(String word) {
//        int value = 0;
//        for (int i = 0; i < word.length(); i++) {
//           int digit = charMap.get(word.charAt(i));
//           if(i == 0 && digit == 0) return -1;
//           value = value * 10 + digit;
//        }
//        return value;
//
//    }

    public static void main(String[] args) {
        String[] words = new String[] {"LEET","CODE"};
        String result = "CODE";

        words = new String[] {"A", "BC"};
        result = "CD";
        VerbalArithmeticPuzzle puzzle = new VerbalArithmeticPuzzle();
        System.out.println(puzzle.isSolvable(words, result));

        words = new String[] {"SEND","MORE"};
        result = "MONEY";
        System.out.println(puzzle.isSolvable(words, result));

        words = new String[] {"SIX","SEVEN","SEVEN"};
        result = "TWENTY";
        System.out.println(puzzle.isSolvable(words, result));

        words = new String[] {"THIS","IS","TOO"};
        result = "FUNNY";
        System.out.println(puzzle.isSolvable(words, result));

        words = new String[] {"LET","CODE"};
        result = "POINT";
        System.out.println(puzzle.isSolvable(words, result));

        words = new String[] {"SEIS","CATORCE","SETENTA"};
        result = "NOVENTA";
        System.out.println(puzzle.isSolvable(words, result));




    }

}
