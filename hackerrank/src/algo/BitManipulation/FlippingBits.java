package algo.BitManipulation;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/8/17.
 */
public class FlippingBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        long i ;
        while (T --> 0) {
            i = scanner.nextLong();
            StringBuffer str = new StringBuffer(Long.toBinaryString(i));
            for (int j = str.length(); j < 32; j++) {
               str.insert(0,'0');
            }
//            System.out.println(str.toString());
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '0')  str.setCharAt(j, '1');
                else str.setCharAt(j,'0');
            }
            System.out.println(Long.valueOf(str.toString(),2));
        }
    }
}
