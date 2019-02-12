package Leecode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Prob_844 {
    public boolean backspaceCompare(String S, String T) {
        String strS = backspaceString(S);
        String strT = backspaceString(T);

        return strS.equals(strT);

    }

    public String backspaceString(String S) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if(ch == '#') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(new Prob_844().backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
