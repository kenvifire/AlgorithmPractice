package contest.june_world_codesprint;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/26.
 */
public class Aorb {

    public static void main(String[] args) {
        Map<Character, String> hexMap = new HashMap<>();
        hexMap.put('0', "0000");
        hexMap.put('1', "0001");
        hexMap.put('2', "0010");
        hexMap.put('3', "0011");
        hexMap.put('4', "0100");
        hexMap.put('5', "0101");
        hexMap.put('6', "0110");
        hexMap.put('7', "0111");
        hexMap.put('8', "1000");
        hexMap.put('9', "1001");
        hexMap.put('A', "1010");
        hexMap.put('B', "1011");
        hexMap.put('C', "1100");
        hexMap.put('D', "1101");
        hexMap.put('E', "1110");
        hexMap.put('F', "1111");

        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        while (Q-- > 0) {
            int K = scanner.nextInt();
            String A, B, C;
            scanner.nextLine();
            int maxLen = 0;
            A = scanner.nextLine();
            B = scanner.nextLine();
            C = scanner.nextLine();

            if (A.length() > maxLen) maxLen = A.length();
            if (B.length() > maxLen) maxLen = B.length();
            if (C.length() > maxLen) maxLen = C.length();

            StringBuilder sA = new StringBuilder(A.length() * 4 + 1);
            StringBuilder sB = new StringBuilder(B.length() * 4 + 1);
            StringBuilder sC = new StringBuilder(C.length() * 4 + 1);

            for (int i = 0; i < maxLen; i++) {
                if (i < A.length()) {
                    sA.append(hexMap.get(A.charAt(i)));
                } else {
                    sA.append(hexMap.get('0'));
                }
            }
            for (int i = 0; i < maxLen; i++) {
                if (i < B.length()) {
                    sB.append(hexMap.get(B.charAt(i)));
                } else {
                    sB.append(hexMap.get('0'));
                }
            }
            for (int i = 0; i < maxLen; i++) {
                if (i < C.length()) {
                    sC.append(hexMap.get(C.charAt(i)));
                } else {
                    sC.append(hexMap.get('0'));
                }
            }


            int ka = 0, kb = 0;
            boolean invalid = false;
            for (int i = 0; i < maxLen * 4 ; i++) {
                if (sC.charAt(i) == '1') {
                    // 0 --> 1
                    if (sA.charAt(i) == '0' && sB.charAt(i) == '0') { //00 --> 0 1
                        kb++;
                        sB.setCharAt(i, '1');
                    }
                } else if (sC.charAt(i) == '0') {
                    // 1 --> 0
                    if (sA.charAt(i) == '1' || sB.charAt(i) == '1') { //11,10,01 --> 00
                        if (sA.charAt(i) == '1') {
                            ka++;
                            sA.setCharAt(i, '0');
                        }
                        if (sB.charAt(i) == '1') {
                            kb++;
                            sB.setCharAt(i, '0');
                        }
                    }
                }
                if (ka + kb > K) {
                    invalid = true;
                    break;
                }

            }

            if (invalid) {
                System.out.println(-1);
                continue;
            }

            // consume k
            int i = 0;
            while (ka + kb < K && i < sC.length())  {
                if(sC.charAt(i) == '1') {
                    if(sA.charAt(i) == '1' && sB.charAt(i) == '1' && ka + kb+1 <=K) {
                        ka++;
                        sA.setCharAt(i,'0');
                    }else  if(sA.charAt(i) == '1' && sB.charAt(i) =='0' && ka +kb +2 <= K) {
                        ka++;
                        sA.setCharAt(i, '0');
                        kb++;
                        sB.setCharAt(i , '1');
                    }
                }
                i++;


            }
            System.out.println(new BigInteger(sA.toString(),2).toString(16).toUpperCase());
            System.out.println(new BigInteger(sB.toString(),2).toString(16).toUpperCase());
        }
    }
}
