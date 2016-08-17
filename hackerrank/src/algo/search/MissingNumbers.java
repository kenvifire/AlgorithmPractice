package algo.search;

import java.util.*;

/**
 * Created by hannahzhang on 16/8/16.
 */
public class MissingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n,A;
        n = scanner.nextInt();
        Map<Integer,Integer> mA = new HashMap<>();
        for (int i = 0; i < n; i++) {
            A = scanner.nextInt();
            Integer value = mA.get(A);
            if(value != null) {
                mA.put(A, value+1);
            }else {
                mA.put(A, 1);
            }
        }
        int m =  scanner.nextInt();
        int B;
        Map<Integer,Integer> mB = new HashMap<>();
        for (int i = 0; i < m; i++) {
            B = scanner.nextInt();
            Integer value = mB.get(B);
            if(value != null) {
                mB.put(B, value+1);
            }else {
                mB.put(B, 1);
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entryB : mB.entrySet()) {
            Integer vA = mA.get(entryB.getKey());
            if(vA == null || vA < entryB.getValue()) {
                resultList.add(entryB.getKey());
            }

        }
        Collections.sort(resultList);
        for (int i = 0; i < resultList.size(); i++) {
            System.out.printf(resultList.get(i)+" ");
        }



    }
}
