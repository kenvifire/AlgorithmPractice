package huawei;

import java.util.Scanner;

public class Round {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            float input = scanner.nextFloat();
            System.out.print(Math.round(input));
        }


    }
}
