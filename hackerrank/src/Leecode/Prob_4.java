package Leecode;

import sun.jvm.hotspot.utilities.Assert;

public class Prob_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1.length > nums2.length ? nums2 : nums1;
        int[] B = nums1.length <= nums2.length ? nums2 : nums1;

        int m = A.length;
        int n = B.length;

        int start = 0, end = m ;

        int i, j;
        double median = 0.0;
        int maxLeft, minRight;

        while (start <= end) {
            i = (start + end) / 2;
            j = (m + n + 1 ) / 2 - i;

            if(i < end && B[j-1] > A[i]) {
                start = i + 1;
            } else if(i > start && A[i-1] > B[j]) {
                end = i - 1;
            }else {
                if(i==0) {
                    maxLeft = B[j-1];
                } else if(j==0) {
                    maxLeft = A[i-1];
                } else {
                    maxLeft = Math.max(A[i-1], B[j-1]);
                }

                if( (m + n) % 2 == 1) return  maxLeft;

                if(i==m) {
                    minRight =  B[j];
                } else if(j==n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(A[i], B[j]);
                }
                return  (maxLeft + minRight) / 2.0;
            }


        }
        return median;

    }

    public static void main(String[] args) {
        Prob_4 prob_4 = new Prob_4();

        Assert.that(prob_4.findMedianSortedArrays(new int[] {2, 4, 6}, new int[] {1, 3, 5}) == 3.5, "failed");
        Assert.that(prob_4.findMedianSortedArrays(new int[] {2, 4, 6, 7}, new int[] {1, 3, 5}) == 4.0, "failed");
        Assert.that(prob_4.findMedianSortedArrays(new int[] {}, new int[] {1, 3, 5}) == 3.0, "failed");
        Assert.that(prob_4.findMedianSortedArrays(new int[] {}, new int[] {}) == 0.0, "failed");
        Assert.that(prob_4.findMedianSortedArrays(new int[] {1, 2, 3, 4}, new int[] {5}) == 3.0, "failed");
        Assert.that(prob_4.findMedianSortedArrays(new int[] {}, new int[] {2, 3}) == 2.5, "failed");
        Assert.that(prob_4.findMedianSortedArrays(new int[] {4}, new int[] {1, 2, 3, 5, 6}) == 2.5, "failed");


    }
}
