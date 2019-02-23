package Leecode;

import utils.AssertUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Prob_20 {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0 ) return true;

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                case ']':
                case '}':
                    if(stack.isEmpty()) return false;
                    if(stack.peek() == map.get(ch)) stack.pop();
                    else return false;
                    break;
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        Prob_20 prob = new Prob_20();
        AssertUtils.assertTrue(prob.isValid("()"));
        AssertUtils.assertTrue(prob.isValid("()[]{}"));
        AssertUtils.assertFalse(prob.isValid("(]"));
        AssertUtils.assertFalse(prob.isValid("([)]"));
        AssertUtils.assertTrue(prob.isValid("{[]}"));

    }
}
