package Leecode;

import utils.PrintUtils;

public class Prob_806 {
    public int[] numberOfLines(int[] widths, String S) {
        int max = 100;

        int line = 0;
        int last = 0;

        int i = 0;
        while(i < S.length()) {
            int left = max;
            while (left > 0 && i < S.length()) {
                int currentWidth = widths[S.charAt(i) - 'a'];
                if(left >= currentWidth) {
                    left -= currentWidth;
                }else {
                    break;
                }
                i++;
            }

            line++;
            last = max - left;
        }

        return new int[] {line, last};
    }

    public static void main(String[] args) {
        PrintUtils.printArray(new Prob_806().numberOfLines(new int[] { 10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                "abcdefghijklmnopqrstuvwxyz"));
        PrintUtils.printArray(new Prob_806().numberOfLines(new int[] {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                "bbbcccdddaaa"));
    }
}
