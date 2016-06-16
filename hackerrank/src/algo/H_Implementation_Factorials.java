package algo;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by kenvi on 16/6/16.
 */
public class H_Implementation_Factorials {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger i = BigInteger.ONE;

        for (int j = 1; j <=n; j++) {
            i = i.multiply(BigInteger.valueOf(j));
        }
        System.out.println(i);
    }
}
