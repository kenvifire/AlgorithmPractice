package algo.hackrank.algo.uncategoried;


import java.util.Scanner;

/**
 * Created by kenvi on 16/6/22.
 */
public class H_String_GameOfThrones {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] array = new int[26];
        //init;
        for (int i = 0; i < 26; i++) {
           array[i] = 0;
        }
        for (int i = 0; i < line.length(); i++) {
            int index = line.charAt(i) - 'a';
            array[index] = array[index] + 1;
        }
        int oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if(array[i] % 2 == 1)  oddCount ++;
        }

        if(oddCount == 0) {
            System.out.println("YES");
        }else if(oddCount == 1 && line.length() %2 == 1) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }


    }
}
