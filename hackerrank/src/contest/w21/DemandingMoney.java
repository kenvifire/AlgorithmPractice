package contest.w21;

import java.util.*;

/**
 * Created by kenvi on 16/6/30.
 */
public class DemandingMoney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N,M;
        N = scanner.nextInt();
        M = scanner.nextInt();
        int[] C = new int[N + 1];

        boolean[][] matrix = new boolean[N+1][N+1];
        int a,b;
        for (int i = 1; i <= N; i++) {
            C[i] = scanner.nextInt();
        }

        for (int i = 0; i < M; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            matrix[a][b] = true;
            matrix[b][a] = true;
        }

        long max = (long)(Math.pow(2,N) - 1);
        long maxMoney = 0;
        long maxCnt = 0;
        Set<Long> resultSet = new HashSet<>();
        for (long i = 1; i < max; i++ ){
//            System.out.println("--------------");
//            System.out.println(Long.toBinaryString(i));
            BitSet bit = new BitSet(N);
            long totalMoney = 0;
            long x = i;
            int index = 1;
            int cnt = 0;
            long result = 0;
            while (x > 0) {
                if(x % 2 == 1 && !bit.get(index)) {
//                    System.out.println("collect money:" + C[index] +" from :" + index);
                    result += Math.pow(2, index);
                    totalMoney += C[index];
                    bit.set(index);
                    cnt++;
                    for(int m = 1; m <=N; m++) {
                        if(matrix[index][m] & !bit.get(m)) {
//                            System.out.println("get way:" + m);
                            bit.set(m);
                            cnt++;
                        }
                    }
                }
                x = x>>1;
                index++;
            }
//            System.out.println("cnt:" + cnt + "total:" + totalMoney +"result:" + resultSet);
                if(totalMoney > maxMoney) {
                    maxMoney = totalMoney;
                    resultSet.clear();
                    resultSet.add(result);
                }else if (totalMoney == maxMoney){
                   resultSet.add(result);
                }
//            System.out.println("------------------");
        }

        System.out.println(maxMoney + " " + resultSet.size());
    }
}
