package algo.hackrank.algo.uncategoried;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by kenvi on 16/6/3.
 */
public class H_DynamicProgramming_FibnacciModified {
    static BigInteger[] result = null;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int N = scanner.nextInt();
        result = new BigInteger[N + 1];
        for(int i = 0;i <= N; i++){
            result[i] =  BigInteger.valueOf(-1);
        }
        result[1] = BigInteger.valueOf(A);
        result[2] = BigInteger.valueOf(B);
        calc(N);

        System.out.println(result[N]);

    }

    public static BigInteger calc(int n) {
        if(n == 1) return result[1];
        if(n == 2) return result[2];
        if(result[n].intValue() != -1) return result[n];
        result[n] = calc(n-1).multiply(calc(n-1)).add( calc(n-2));
        return result[n];
    }
}
