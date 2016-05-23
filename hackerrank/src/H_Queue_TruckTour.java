
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kenvi on 16/5/21.
 */
public class H_Queue_TruckTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int min = 0;
        int a,d;
        int total = 0;
        int start = 0;
        int index = 0;
        int n = N;
        while (N --> 0) {

            a = scanner.nextInt();
            d = scanner.nextInt();

            total +=  (a-d);
            if(total < min) {
                min = total;
                start = index;
            }
            index ++;

        }

        System.out.print((start + 1) % n);

    }
}
