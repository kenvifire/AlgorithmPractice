package Leecode;

import utils.AssertUtils;
import utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class Prob_1002 {
    public List<String> commonChars(String[] A) {
        int[] charCnt = new int[26];

        for (int i = 0; i < 26; i++) charCnt[i] = -1;

        for (String str : A) {
            int[] currentCnt = new int[26];
            for (int i = 0; i < str.length(); i++) {
                currentCnt[str.charAt(i) - 'a'] += 1;
            }

            for (int i = 0; i < 26; i++) {
                if(charCnt[i] == -1) {
                    charCnt[i] = currentCnt[i];
                } else {
                    charCnt[i] = Math.min(charCnt[i], currentCnt[i]);
                }
            }
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < charCnt.length; i++) {
            if(charCnt[i] > 0) {
                for (int j = 0; j < charCnt[i]; j++) {
                    result.add(String.valueOf((char)('a' + i)));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Prob_1002 prob = new Prob_1002();

        PrintUtils.printStringList(prob.commonChars(new String[]{"bella","label","roller"}));
        PrintUtils.printStringList(prob.commonChars(new String[]{"cool","lock","cook"}));
        PrintUtils.printStringList(prob.commonChars(new String[]{}));
        PrintUtils.printStringList(prob.commonChars(new String[]{"", "aa"}));
        PrintUtils.printStringList(prob.commonChars(new String[]{"aaa", "aa", "a"}));
    }
}
