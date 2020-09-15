package huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NonRepeatNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();

            Set<Integer> numSet = new HashSet<>();
            int result = 0;

            while (num > 0) {
                int curr = num % 10;
                num /= 10;
                if(!numSet.contains(curr)) {
                    result = 10 * result + curr;
                    numSet.add(curr);
                }
            }
            System.out.println(result);
        }
    }
}
