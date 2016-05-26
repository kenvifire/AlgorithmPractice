package ds;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by kenvi on 16/5/26.
 */
public class H_DisjointSet_ComponentsInAGraph {

    public static void main(String[] args) throws Exception{
        File file = new File("/tmp/in");
        InputStream in = new FileInputStream(file);
        Scanner scanner = new Scanner(file);

        int N = scanner.nextInt();

        int b,g;
        int[] disjointSet = new int[2*N+1];
        for (int i = 1; i <= 2*N; i++) {
            disjointSet[i] = -1;
        }

        while( N --> 0) {
            b = scanner.nextInt();
            g = scanner.nextInt();

            disjointSet[b] = g;
            disjointSet[g] = b;

        }

        int min = 0,max = Integer.MAX_VALUE;
        for (int i = 1; i<= 2*N; i++) {
            int count = 0;
            int j = i;
            while(disjointSet[j] !=-1) {

            }
        }


    }
}
