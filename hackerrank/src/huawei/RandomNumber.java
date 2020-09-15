package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class RandomNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] numbers = new int[num];
            for (int i = 0; i < num; i++) {
                numbers[i] = scanner.nextInt();
            }
            Arrays.sort(numbers);
            int prevValue = numbers[0];
            System.out.println(prevValue);
            for (int i = 1; i < num; i++) {
                if(numbers[i] != prevValue) {
                    prevValue = numbers[i];
                    System.out.println(prevValue);
                }
            }

        }
    }
}
