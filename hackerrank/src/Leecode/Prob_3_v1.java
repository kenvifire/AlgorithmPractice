package Leecode;

import com.sun.tools.javac.util.Assert;

public class Prob_3_v1 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int max = 1, len = 1;
        //
        for(int i = 1; i < s.length(); i++) {
            String subStr = s.substring(i - len, i);
            char c = s.charAt(i);
            if(!subStr.contains(c + "")) {
                len++;
            } else {
                if (max < len)
                    max = len;
                i = i - len +  1;
                len = 1;
            }
        }
        if(max < len) {
            max = len;
        }
        return max;

    }

    public static void main(String[] args) {
        Prob_3_v1 prob_3V1 = new Prob_3_v1();
        Assert.check(prob_3V1.lengthOfLongestSubstring("dvdf") == 3);
        Assert.check(prob_3V1.lengthOfLongestSubstring("") == 0);
        Assert.check(prob_3V1.lengthOfLongestSubstring("ab") == 2);
        Assert.check(prob_3V1.lengthOfLongestSubstring("abc") == 3);
        Assert.check(prob_3V1.lengthOfLongestSubstring("aaa") == 1);
        Assert.check(prob_3V1.lengthOfLongestSubstring("aba") == 2);
        Assert.check(prob_3V1.lengthOfLongestSubstring("aab") == 2);
        Assert.check(prob_3V1.lengthOfLongestSubstring("aaabbb") == 2);
        Assert.check(prob_3V1.lengthOfLongestSubstring("aaabbbcd") == 3);

        Assert.check(prob_3V1.lengthOfLongestSubstring("abcabcbb") == 3);
        Assert.check(prob_3V1.lengthOfLongestSubstring("bbbbb") == 1);
        Assert.check(prob_3V1.lengthOfLongestSubstring("pwwkew") == 3);
    }
}
