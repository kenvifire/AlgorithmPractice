package contest.infinitum16;

import java.nio.channels.Pipe;
import java.util.Scanner;

/**
 * Created by kenvi on 16/9/3.
 */
public class XrangeAnPizza {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int nRoate = 0;
        int nFlip = 0;
        int nFlipCount = 0;
        while (m -- > 0) {
            int type = scanner.nextInt();
            int c = scanner.nextInt();
            if(type == 1) {
                if(nFlip == 0){
                    nRoate +=c;
                }else {
                    nRoate -=c;
                }

            }
            if(type == 2) {
                nFlip++;
                if(nFlip == 2) {
                    nFlip=0;
                    nFlipCount-=c;
                }else {
                    nFlipCount+=c;
                }

            }
        }
//        System.out.println(String.format("%s,%s,%s",nRoate,nFlip,nFlipCount));
        int count = ( n - (nRoate%n)) + nFlipCount;
        count = count % n;
        if(count < 0) count = n+count;

        if(nFlip == 1) {
            System.out.print(2 + " ");
            System.out.print( count % n );
        }else {
            System.out.print(1 + " ");
            System.out.print(count % (n));
        }



    }
}
