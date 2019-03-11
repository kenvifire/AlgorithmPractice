package Leecode;

import utils.AssertUtils;

import java.util.Stack;

public class Prob_921 {
    public int minAddToMakeValid(String S) {
        if(S.length() == 0) return 0;
        Stack<Character> stack = new Stack<>();

        int cnt  = 0;
        stack.push(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            char ch = S.charAt(i);
            if(stack.isEmpty()) {
               if(ch == '(') {
                   stack.push(ch);
               } else {
                    cnt++;
               }
            } else {
                if(ch == ')') {
                    if(stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }else {
                    stack.push(ch);
                }
            }
        }

        return cnt + stack.size();
    }

    public static void main(String[] args) {
        Prob_921 prob = new Prob_921();
        AssertUtils.equals(1, prob.minAddToMakeValid("())"));
        AssertUtils.equals(3, prob.minAddToMakeValid("((("));
        AssertUtils.equals(0, prob.minAddToMakeValid("()"));
        AssertUtils.equals(4, prob.minAddToMakeValid("()))(("));
        AssertUtils.equals(0, prob.minAddToMakeValid(""));
        AssertUtils.equals(1, prob.minAddToMakeValid("("));
        AssertUtils.equals(1, prob.minAddToMakeValid(")"));
    }
}
