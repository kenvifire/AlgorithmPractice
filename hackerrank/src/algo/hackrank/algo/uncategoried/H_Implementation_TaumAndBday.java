package algo.hackrank.algo.uncategoried;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by kenvi on 16/6/16.
 */
public class H_Implementation_TaumAndBday {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long b = in.nextLong();
            long w = in.nextLong();
            long x = in.nextLong();
            long y = in.nextLong();
            long z = in.nextLong();
            BigInteger amount = BigInteger.ZERO;
            //B--X
            //W--Y
            //X<-->Y Z
            if(x-y > z) {
                //amount = y*(w+b) + b*z;
                amount = amount.add(BigInteger.valueOf(w).add(BigInteger.valueOf(b)).multiply(BigInteger.valueOf(y))).
                        add(BigInteger.valueOf(b).multiply(BigInteger.valueOf(z)));
            }else if(y -x > z) {
                //amout = x*(w+b) + w*z;
                amount = amount.add(BigInteger.valueOf(w).add(BigInteger.valueOf(b)).multiply(BigInteger.valueOf(x))).
                        add(BigInteger.valueOf(w).multiply(BigInteger.valueOf(z)));
            }else {
                //amount = b*x + w*y;
                amount = BigInteger.valueOf(x).multiply(BigInteger.valueOf(b));
                amount = amount.add(BigInteger.valueOf(w).multiply(BigInteger.valueOf(y)));
            }
            System.out.println(amount);


        }
    }
}
