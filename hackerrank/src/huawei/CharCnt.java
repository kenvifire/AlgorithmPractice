package huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CharCnt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            Set<Character> characterSet = new HashSet<>();
            for (char ch : str.toCharArray()) {
                if(ch > 0 && ch < 127) {
                    characterSet.add(ch);
                }
            }
            System.out.println(characterSet.size());
        }

    }
}
