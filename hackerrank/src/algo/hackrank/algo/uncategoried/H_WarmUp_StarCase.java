package algo.hackrank.algo.uncategoried;

import java.util.Scanner;

/**
 * Created by kenvi on 16/6/3.
 */
public class H_WarmUp_StarCase {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        StringBuilder sb = new StringBuilder(N);
        for(int i = 0;i < N; i++){
            sb.append(' ');
        }
        for(int i = 0;i < N; i++){
            sb.setCharAt(N-1-i,'#');
            System.out.println(sb.toString());
        }


    }
}
