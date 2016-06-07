package algo;



import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/7.
 */
public class H_Implementation_ServiceLane {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int T = scanner.nextInt();
        int[] lane = new int[N];

        for (int i = 0; i < N; i++) {
            lane[i] = scanner.nextInt();
        }
        int a,b;
        for (int i = 0; i < T; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            int min = 3;
            for (int j = a; j <=b ; j++) {
                if(lane[j] < min) {
                    min = lane[j];
                }

            }
            System.out.println(min);

        }

    }
}
