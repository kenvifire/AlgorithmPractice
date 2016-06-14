package algo;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/14.
 */
public class H_Implementation_LibraryFine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int da = in.nextInt();
        int ma = in.nextInt();
        int ya = in.nextInt();
        int de = in.nextInt();
        int me = in.nextInt();
        int ye = in.nextInt();

        int fine = 0;
        if( ya <= ye && ma <= me && da <= de) {
            fine = 0;
        }else if (ye == ya && me == ma && da > de) {
            fine = 15 * (da - de);
        }else if (ye == ya && ma > me) {
            fine = 500 * (ma - me);
        }else if(ya > ye){
            fine = 10000;
        }

        System.out.println(fine);
    }
}
