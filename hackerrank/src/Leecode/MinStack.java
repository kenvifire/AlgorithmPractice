package Leecode;

import java.util.LinkedList;
import java.util.List;

public class MinStack {
    /** initialize your data structure here. */
    private List<Integer> stack;
    private int min = Integer.MAX_VALUE;
    private int size = 0;
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
       stack.add(x);
       size++;
       if(x < min) min = x;

    }

    public void pop() {
        stack.remove(size - 1);
        size--;
        min = Integer.MAX_VALUE;

        for (Integer num : stack) {
            if(num < min) min = num;
        }

    }

    public int top() {

        return stack.get(size - 1);

    }

    public int getMin() {
        return min;
    }


}
