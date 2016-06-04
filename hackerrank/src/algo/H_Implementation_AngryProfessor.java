package algo;

import java.util.Scanner;

/**
 * Created by kenvi on 16/6/3.
 */
public class H_Implementation_AngryProfessor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int N,K;
        for(int i = 0;i < T; i++){
            N = scanner.nextInt();
            K = scanner.nextInt();
            int count = 0;
            for (int j = 0; j <N; j++) {
                if(scanner.nextInt() <= 0) {
                    count ++;
                }
            }

            if(count >= K) {
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }



    }
}
