package algo.hackrank.algo.uncategoried;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by kenvi on 16/6/6.
 */
public class H_Implementation_SherlockAndSquares {
    static BitSet squareSet = new BitSet(1000000000);
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int A,B;
        for (int i = 0; i < N; i++){
            A = scanner.nextInt();
            B = scanner.nextInt();
            int rootA = (int)Math.ceil(Math.sqrt(A));
            int rootB = (int)Math.ceil(Math.sqrt(B));
            if(rootB * rootB == B) rootB++;
            System.out.println(rootB - rootA);

        }
    }

}
