package algo.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kenvi on 16/7/11.
 */
public class CountingSort2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        int x;
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int i = 0; i <=99; i++) {
            countMap.put(i, 0);
        }
        while (n-->0) {
            x = scanner.nextInt();
            Integer value = countMap.get(x);
            countMap.put(x, value+1);

        }

        for (int i = 0; i <= 99; i++) {
            int count = countMap.get(i);
            for (int j=1; j<=count; j ++) {
                System.out.print(i + " ");
            }
        }


    }
}
