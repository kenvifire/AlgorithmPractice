package algo;

import java.util.Scanner;

/**
 * Created by kenvi on 16/6/3.
 */
public class H_WarmUp_PlusMinus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int posCnt = 0 ,negCnt = 0,zeroCnt = 0;
        int a;
        for (int i = 0; i < N; i++) {
            a = scanner.nextInt();
            if(a>0) {
                posCnt ++;
            }else if(a<0) {
                negCnt++;
            }else {
                zeroCnt++;
            }

        }

//        System.out.println(round(posCnt / (1.0f * N), 6));
        System.out.println(String.format("%.6f",posCnt / (1.0f * N)));
        System.out.println(String.format("%.6f", negCnt / (1.0f * N)));
        System.out.println(String.format("%.6f", zeroCnt / (1.0f * N)));
    }

    public static float round(float number, int scale) {
        int pow = 10;
        for (int i = 1;i < scale; i++)
            pow *=10;
        float temp = number * pow;
        return (float)(int)((temp - (int)temp) >= 0.5f ? temp+1 : temp) / pow;
    }
}
