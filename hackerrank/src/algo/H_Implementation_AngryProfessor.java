package algo;

import java.util.Scanner;

/**
 * Created by kenvi on 16/6/3.
 */
public class H_Implementation_AngryProfessor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int N = scanner.nextInt();
        int index = 0;
        for(int i = 0;i < N; i++){
            if(V == scanner.nextInt()) {
                index = i;
            }
        }

        System.out.println(index);


    }
}
