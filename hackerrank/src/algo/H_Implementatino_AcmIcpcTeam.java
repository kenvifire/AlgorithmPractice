package algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kenvi on 16/6/15.
 */
public class H_Implementatino_AcmIcpcTeam {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String topic[] = new String[n];
        for(int topic_i=0; topic_i < n; topic_i++){
            topic[topic_i] = in.next();
        }
        Map<Integer,Integer> countMap = new HashMap<>();
        int maxCnt = 0;
        countMap.put(0,0);
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int result = countBit(topic[i] , topic[j], m);
                Integer value = countMap.get(result);
                if(value == null) {
                    countMap.put(result, 1);
                    if(result > maxCnt) {
                        maxCnt = result;
                    }
                }else {
                    countMap.put(result, value+1);
                    if(result > maxCnt) {
                        maxCnt = result;
                    }
                }
            }
        }

        System.out.println(maxCnt);
        System.out.println(countMap.get(maxCnt));

    }
    static int countBit(String a, String b ,int m) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
           if(a.charAt(i) == '1' || b.charAt(i) == '1')  {
               cnt++;
           }
        }

        return cnt;
    }
}
