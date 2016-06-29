package contest.w21;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kenvi on 16/6/29.
 */
public class LazySorting {
    static long[] fac = new long[19];
    public static void main(String[] args) {
        for (int i = 0; i < 19; i++) {
            fac[i] = -1;
        }
        fac[1] = 1;
        Scanner scanner = new Scanner(System.in);
        int N;
        N = scanner.nextInt();
        int p;
        Map<Integer,Integer> countMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < N; i++) {
            p = scanner.nextInt();
            Integer value = countMap.get(p);
            if(value == null) {
                countMap.put(p,1);
            }else {
                countMap.put(p, value+1);
            }
        }

        long total = factorial(N);
        long sortCnt = 1;
        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()){
           if(entry.getValue() > 1)  {
               sortCnt *= factorial(entry.getValue());
           }
        }

//        if(sortCnt == total) {
//            System.out.println("0.000000");
//            return;
//        }
        double result = (1.0 * total) / (1.0* sortCnt);
        System.out.println(String.format("%.6f", result));

    }


    static long factorial(int n ) {
        if(fac[n] != -1) {
            return fac[n];
        }else {
            fac[n] = n * factorial(n-1);
            return fac[n];
        }
    }
}
