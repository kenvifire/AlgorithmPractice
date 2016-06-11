package contest.backrockcodesprint;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/11.
 */
public class CurrencyArbitrage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        double usd2Eur,eur2Gbp,gbp2Usd;

        while (T --> 0) {

            usd2Eur = scanner.nextDouble();
            eur2Gbp = scanner.nextDouble();
            gbp2Usd = scanner.nextDouble();
            double rate = (1/usd2Eur) * (1/eur2Gbp) * (1/gbp2Usd);
            if(rate > 1) {
                System.out.println((int)(100000*(rate-1)));
            }else {
                System.out.println(0);
            }
        }



    }
}
