package Leecode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(Comparator.naturalOrder());
        this.k = k;
        for (int n : nums) {
            pq.offer(n);

            if(pq.size() > k) {
                pq.poll();
            }
        }

    }

    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k) pq.poll();
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] {4,5,8,2});
        kthLargest.add(3);
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(9);
        kthLargest.add(4);
    }

}
