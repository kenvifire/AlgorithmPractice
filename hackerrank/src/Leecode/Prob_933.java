package Leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Prob_933 {
    class RecentCounter {

        private Queue<Integer> queue = new ArrayDeque<>();

        public RecentCounter() {

        }

        public int ping(int t) {
           queue.add(t);
           while (!queue.isEmpty()) {
               if(queue.peek() < 3000 - t) queue.remove();
               else break;
           }
           return queue.size();

        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
