package contest.june_world_codesprint;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/26.
 */
public class EqualStacks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        int height1 = 0, height2 = 0, height3 = 0;
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
            height1 += h1[h1_i];
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
            height2 += h2[h2_i];
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
            height3 += h3[h3_i];
        }

        int point;

        int s_1=0, s_2 = 0, s_3 = 0;

        while (true) {
            if(height1 == height2 && height2 == height3 ) break;
            if(height1 == 0 || height2 ==0 || height3 ==0 ) break;

            if(height1 >= height2 && height1 >= height3) point = 1;
            else if(height2 >= height1 && height2 >= height3) point = 2;
            else point = 3;

            if (point == 1) {
                height1 -= h1[s_1];
                s_1++;
            }else if(point == 2) {
                height2 -= h2[s_2];
                s_2++;
            }else {
                height3 -= h3[s_3];
                s_3++;
            }
        }

        if(height1 == 0 || height2 == 0 || height3 == 0) {
            System.out.println(0);
        }else {
            System.out.println(height1);
        }


    }
}
