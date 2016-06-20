package algo;

import java.util.Scanner;

/**
 * Created by kenvi on 16/6/17.
 */
public class H_Implementation_KaprebarNumbers {
    public static void main(String[] args) {
        int p, q;
        Scanner scanner = new Scanner(System.in);

        p = scanner.nextInt();
        q = scanner.nextInt();
        int count = 0;

        for (int i = p; i <= q; i++) {
            if(isKnum(i)) {
                System.out.print(i + " ");
                count ++;
            }
        }
        if(count == 0) {
            System.out.print("INVALID RANGE");
        }
    }

    public static boolean isKnum(long num){
        long square = num * num;
        int d = getCount(num);
        long power =  (long)Math.pow(10,d);
        long right = square % power;
        long left = square / power;
        return (left + right) == num;

    }

    public static int getCount(long num) {
        int count = 0;
        while(num > 0){
            num = num / 10;
            count++;
        }
        return count;
    }
}
