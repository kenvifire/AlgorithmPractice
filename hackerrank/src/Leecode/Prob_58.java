package Leecode;

import utils.AssertUtils;

public class Prob_58 {
    public int lengthOfLastWord(String s) {
        if(s.length() <= 0)  return 0;

        int start = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
           if(s.charAt(i) != ' ' && start == -1) {
               start = i;
           } else if((s.charAt(i) == ' ' || i == 0) && start != -1){
               return (start - i) + (i== 0 && s.charAt(i) != ' ' ? 1 : 0);
           }
        }
        if(start >= 0 ) return start + 1;
        return 0;
    }

    public static void main(String[] args) {
        Prob_58 prob = new Prob_58();
        AssertUtils.equals(5, prob.lengthOfLastWord("  Hello world"));
        AssertUtils.equals(2, prob.lengthOfLastWord("Hello world 11   "));
        AssertUtils.equals(2, prob.lengthOfLastWord("11"));
        AssertUtils.equals(2, prob.lengthOfLastWord(" 11"));
        AssertUtils.equals(2, prob.lengthOfLastWord(" 11 "));
        AssertUtils.equals(0, prob.lengthOfLastWord(""));
        AssertUtils.equals(0, prob.lengthOfLastWord(" "));
        AssertUtils.equals(0, prob.lengthOfLastWord("         "));
        AssertUtils.equals(1, prob.lengthOfLastWord("a"));
        AssertUtils.equals(2, prob.lengthOfLastWord("aa  "));
    }
}
