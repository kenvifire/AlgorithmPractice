package huawei;

import java.util.Scanner;

public class Bottle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) break;
            int cnt = 0;
            while (n >= 3) {
                cnt += n / 3;
                n = n % 3 + n / 3;
            }
            System.out.println(cnt + (n == 2 ? 1 : 0));

        }
    }
}
