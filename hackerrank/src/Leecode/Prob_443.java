package Leecode;

import utils.AssertUtils;

public class Prob_443 {
    public int compress(char[] chars) {
        if(chars.length <= 1) return chars.length;
        int index = 0;
        char current = chars[index];
        int cnt = 1;
        char pos = 0;

        for (index = 1; index < chars.length; index++) {
           if (chars[index] == current) {
               cnt++;

           } else {
                chars[pos++] = current;

                if(cnt > 1) {
                    char[] cntChar = Integer.toString(cnt).toCharArray();

                    for (int i = 0; i <cntChar.length; i++) {
                        chars[pos++] = cntChar[i];
                    }
                }

                current = chars[index];
                cnt = 1;
           }
        }

        chars[pos++] = current;
        if(cnt > 1) {
            char[] cntChar = Integer.toString(cnt).toCharArray();

            for (int i = 0; i < cntChar.length; i++) {
                chars[pos++] = cntChar[i];
            }
        }

        return pos;

    }

    public static void main(String[] args) {
        Prob_443 prob = new Prob_443();
        char[] input = "aabbccc".toCharArray();

//        AssertUtils.equals(6, prob.compress(input));
//        AssertUtils.equals(1, prob.compress("a".toCharArray()));
        AssertUtils.equals(4, prob.compress("abbbbbbbbbbbb".toCharArray()));
    }
}
