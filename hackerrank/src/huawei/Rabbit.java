package huawei;

import java.util.Scanner;

public class Rabbit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            System.out.println(rabbit(num));
        }
    }

    static int rabbit(int n) {
        if(n==1 || n==2) {
            return 1;
        } else {
            return rabbit(n - 1) + rabbit(n - 2);
        }
    }


}
