package Leecode;

import java.util.Stack;

public class MyQueue {
   private Stack<Integer>  front;
   private Stack<Integer> back;

    /** Initialize your data structure here. */
    public MyQueue() {
        front = new Stack<>();
        back = new Stack<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        back.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        refill();
        return front.pop();

    }

    private void refill() {
        if(front.empty()) {
            while (!back.empty()) {
                front.push(back.pop());
            }
        }
    }


    /** Get the front element. */
    public int peek() {
        refill();
        return front.peek();
    }



    /** Returns whether the queue is empty. */
    public boolean empty() {
        return back.empty() && front.empty();
    }
}
