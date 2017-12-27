package algo.hackrank.algo.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kenvi on 2017/12/27.
 */
public class NonDivisibleSubset {
    /**
     * https://www.hackerrank.com/challenges/non-divisible-subset/problem
     * Each a[i] mod by k, reminder can be only in [0, k), we call this b,
     * For any b[m] and b[n] whose sum can be evenly divided by k, they must
     * meet b[m] + b[n] = k. So we only need to check this 2 pairs, and see which
     * one contains more numbers.
     * Edge case : for numbers are in b[0], their count should be 1.
     * Edge case : for even numbers, k/2 should be excluded, because 2 numbers in b[k/2] sums up to k, for this case, only count 1.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < k; i++){
            countMap.put(i, 0);
        }


        // get count for each number in [0, k)
        for(int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int key = a % k;

            countMap.put(key, countMap.get(key) + 1);

        }

        // find pairs
        int count = 0;

        //Edge case 1
        if(countMap.get(0) >= 1) {
            count = 1;
        }
        //Edge case 2
        if(k % 2 == 0 && countMap.get(k/2) > 0) {
            countMap.put(k/2, 1);
        }

        for (int i = 1; i <= k / 2; i++) {

            int b1 = countMap.get(i);
            int b2 = countMap.get(k - i);

            count += b1 > b2 ? b1 : b2;
        }

        System.out.println(count);

    }
}
