package algo;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/18.
 */
public class H_Implementation_Encryption {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        StringBuilder sb = new StringBuilder(s.replaceAll(" ",""));
        long L = sb.length();
        double root = Math.sqrt(L);
        int ceil = (int)Math.ceil(root);
        int floor = (int)Math.floor(root);

        int row,column;
        if(ceil == floor) {
            row = ceil;
            column = ceil;
        }else {
            if(floor * ceil >= L) {
               column = ceil;
               row = floor;
            }else {
                row = ceil;
                column = ceil;
            }
        }

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if(j*column + i < L) {
                    System.out.print(sb.charAt(j*column + i));
                }
            }
            System.out.print(' ');
        }
    }




}
