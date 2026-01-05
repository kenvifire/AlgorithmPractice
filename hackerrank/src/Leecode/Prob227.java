package Leecode;

import java.util.Stack;

public class Prob227 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && Character.isWhitespace(s.charAt(i))) { i++ ;}

            char c = s.charAt(i);
            int currNum = 0;
            if(Character.isDigit(c)){
                int idx = 1;
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                     currNum += (c - '0') * idx;
                     idx *= 10;
                     i++;
                }
                stack.push(currNum);
            }
            while (i < s.length() && Character.isWhitespace(s.charAt(i))) { i++ ;}
            c = s.charAt(i);
            if(c == '/') {
               stack.push(stack.pop()/currNum);
            } else if(c == '*') {
                stack.push(stack.pop()*currNum);
            } else if(c == '+') {
                stack.push(stack.pop()+currNum);
            } else if(c == '-') {
                stack.push(stack.pop()-currNum);
            }

        }
        return stack.peek();
    }

    public static void main(String[] args) {
        Prob227 p = new Prob227();
        System.out.println(p.calculate("1+2"));
    }
}
