/**
 * Created by hannahzhang on 16/5/24.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class H_Heap_FindMedian {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(Comparator.<Integer>naturalOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>(Comparator.<Integer>reverseOrder());
        int a;
        for (int i = 1; i <= N; i++) {
            a = scanner.nextInt();
            if (maxQueue.size() == 0 || a <= maxQueue.peek()) {
                if(maxQueue.size() > minQueue.size()) {
                    minQueue.offer(maxQueue.poll());
                }
                maxQueue.offer(a);
            }else if (minQueue.size() == 0 || a > minQueue.peek()) {
                if (minQueue.size() == 0 || a > minQueue.peek()) {
                    if(minQueue.size() > maxQueue.size()) {
                        maxQueue.offer(minQueue.poll());
                    }
                }
                minQueue.offer(a);
            }else {
                if(minQueue.size() > maxQueue.size()) {
                    maxQueue.offer(a);
                }else {
                    minQueue.offer(a);
                }
            }

            //find mind
            double min = 0;
            if(maxQueue.size() > minQueue.size()) {
                min = maxQueue.size();
            }else if(minQueue.size() > maxQueue.size()) {
                min = minQueue.size();
            }else if(!minQueue.isEmpty() && minQueue.size() == maxQueue.size()) {
                min = (1.0 * maxQueue.peek() + 1.0 * minQueue.peek())/2;
            }

            System.out.printf("%.1f\n",min);

        }
    }
}
