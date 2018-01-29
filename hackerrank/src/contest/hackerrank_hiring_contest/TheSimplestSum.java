package contest.hackerrank_hiring_contest;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by kenvi on 2018/1/27.
 */
public class TheSimplestSum {
    static int simplestSum(int k, long a, long b) {
        BigInteger sum = BigInteger.valueOf(0);
        long[] temp = new long[100];

//init
//calculate and cache
        long t = 0;
        int cnt = 0;
        for (int s = 1; t <= b; s++) {
            t = (long) ((Math.pow(k, s) - 1) / (k - 1));
            temp[s] = t;
            if (t <= b) {
                cnt = s;
            }
        }



        for (int i = 1; i <= cnt ; i++) {
            long origin = temp[i];
            long count = (b - (origin > a ? origin : a)) + 1;
            sum = sum.add(BigInteger.valueOf(count).multiply(BigInteger.valueOf(temp[i])));
        }

        return Integer.valueOf(sum.mod(BigInteger.valueOf(1000000007)).toString());
    }




    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int k = in.nextInt();
            long a = in.nextLong();
            long b = in.nextLong();
            int result = simplestSum(k, a, b);
            System.out.println(result);
        }
        in.close();
    }
}
