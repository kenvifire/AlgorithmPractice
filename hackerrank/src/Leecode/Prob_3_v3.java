package Leecode;

import com.sun.tools.javac.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class Prob_3_v3 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> locMap = new HashMap<>();

        for (int j = 0, i = 0; j < s.length(); j++) {
              if (locMap.containsKey(s.charAt(j)))  {
                  i = Math.max(locMap.get(s.charAt(j)), i);
              }

              max = Math.max(max, j - i +1);
              locMap.put(s.charAt(j), j + i);
        }
        return max;

    }

    public static void main(String[] args) {
        Prob_3_v3 prob_3V2 = new Prob_3_v3();
        Assert.check(prob_3V2.lengthOfLongestSubstring("dvdf") == 3);
        Assert.check(prob_3V2.lengthOfLongestSubstring("") == 0);
        Assert.check(prob_3V2.lengthOfLongestSubstring("ab") == 2);
        Assert.check(prob_3V2.lengthOfLongestSubstring("abc") == 3);
        Assert.check(prob_3V2.lengthOfLongestSubstring("aaa") == 1);
        Assert.check(prob_3V2.lengthOfLongestSubstring("aba") == 2);
        Assert.check(prob_3V2.lengthOfLongestSubstring("aab") == 2);
        Assert.check(prob_3V2.lengthOfLongestSubstring("aaabbb") == 2);
        Assert.check(prob_3V2.lengthOfLongestSubstring("aaabbbcd") == 3);

        Assert.check(prob_3V2.lengthOfLongestSubstring("abcabcbb") == 3);
        Assert.check(prob_3V2.lengthOfLongestSubstring("bbbbb") == 1);
        Assert.check(prob_3V2.lengthOfLongestSubstring("pwwkew") == 3);
    }
}
