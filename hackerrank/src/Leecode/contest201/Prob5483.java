package Leecode.contest201;

import java.util.Stack;

public class Prob5483 {
    public String makeGood(String s) {
        if(s.length() <= 1) return s;

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int i = 1;
        while(i < s.length()) {
            char ch = s.charAt(i);

            if(!stack.isEmpty()) {
                char ch1 = stack.peek();
                if(Math.abs(ch1 - ch) == 32) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }

            i++;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();


    }


    public static void main(String[] args) {
        Prob5483 prob = new Prob5483();
        prob.makeGood("abBAcC");
    }
}
