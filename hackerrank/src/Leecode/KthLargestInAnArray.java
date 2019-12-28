package Leecode;

import utils.AssertUtils;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if(queue.size() >= k) {
                if(num > queue.peek()) {
                    queue.remove();
                    queue.offer(num);
                }

            } else {
                queue.offer(num);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargestInAnArray solution = new KthLargestInAnArray();
        AssertUtils.equals(solution.findKthLargest(new int[] {3,2,1,5,6,4}, 2), 5);
        AssertUtils.equals(solution.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4), 4);
    }
}
