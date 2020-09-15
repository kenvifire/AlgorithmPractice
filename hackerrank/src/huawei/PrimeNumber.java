package huawei;


import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long num = scanner.nextLong();

            for (int i = 2; i <= num; i++) {
                while(num != i) {
                    if (num % i == 0) {
                        num = num / i;
                        System.out.printf("%d ", i);
                    } else {
                        break;
                    }
                }
            }
            if(num >= 1) {
                System.out.printf("%d ", num);
            }

        }
    }
}
