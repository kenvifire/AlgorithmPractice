package algo.implementation;

import java.util.List;
import java.util.Scanner;

/**
 * Created by kenvi on 16/10/10.
 */
public class TheGridSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String[] G = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String[] P = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }

            boolean flag = true;
            boolean result = false;
            for (int i = 0; i <= G.length - P.length; i++ ) {
                int searchIndex = 0;
                int index = -1;
                while((index = G[i].substring(searchIndex).indexOf(P[0])) != -1) {
                    flag = true;
                    for (int m = 1, n = i + 1; m < P.length && n < G.length; m++, n++) {
                        int start = searchIndex + index;
                        int end = searchIndex + index + P[m].length();
                        if(end > G[n].length() ) {
                            flag = false;
                            break;
                        }
                        if (!(G[n].substring(start, end).equals(P[m]))) {
                            flag = false;
                        }
                    }
                    searchIndex+=1;

                    if (flag && index>=0) break;
                }
                if(flag && index>=0) {
                    result = true;
                    break;
                }

            }

            System.out.println(result ? "YES" : "NO");
        }


    }
}
