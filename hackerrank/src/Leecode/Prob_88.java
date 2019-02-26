package Leecode;

public class Prob_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;

        int index = len - 1;
        int i = m - 1, j = n - 1;

        while (i >= 0 || j >= 0) {
            if(i >= 0 && j >= 0) {
                if(nums1[i] > nums2[j]) {
                   nums1[index--]  = nums1[i--];
                } else {
                   nums1[index--]  = nums2[j--];
                }

            } else if(i >= 0) {
                nums1[index --]  = nums1[i--];
            } else {
                nums1[index --]  = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {

    }
}
