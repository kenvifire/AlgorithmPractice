package Leecode;

import utils.AssertUtils;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestInAnArray2 {
    public int findKthLargest(int[] nums, int k) {
        return select(nums, 0 ,nums.length - 1, k - 1);
    }

    int partition(int[] array, int left, int right, int pivotIndex) {
        int pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (array[i] >= pivotValue) {
                swap(array, storeIndex, i);
                storeIndex++;
            }
        }
        swap(array, right, storeIndex);
        return storeIndex;
    }

    int select(int[] array, int left, int right, int k) {
        if(left == right) return array[left];
        int pivotIndex = left;
        pivotIndex = partition(array, left, right, pivotIndex);
        if(k == pivotIndex) return array[k];
        else if (k < pivotIndex) {
            return select(array, left, pivotIndex - 1, k);
        }
        else {
            return select(array, pivotIndex + 1, right, k);

        }
    }

    void swap(int[] array, int m, int n) {
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }

    public static void main(String[] args) {
        KthLargestInAnArray2 solution = new KthLargestInAnArray2();
        AssertUtils.equals(solution.findKthLargest(new int[] {3,2,1,5,6,4}, 2), 5);
        AssertUtils.equals(solution.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4), 4);
    }
}
