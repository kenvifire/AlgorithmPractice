package contest.hackerrank_hiring_contest;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by kenvi on 2018/1/28.
 */
public class ArrayandQueries {

    static int arrayAndQueries(long[] A, long[][] queries) {
       SortedMap<Long, Long> countMap = new TreeMap<>();


        for (long c : A) {
            Long value = countMap.get(c);
            if(value == null) {
                value = 1l;
            } else {
                value = value + 1;
            }
            countMap.put(c, value);
        }

        long sum = 0;
        long lastCnt = 0;
        for (int q = 0; q < queries.length; q++) {
            int index = (int)queries[q][0] - 1;
            long oldKey = A[index];
            long newKey = queries[q][1];
            A[index] = newKey;

            if (newKey == oldKey && lastCnt != 0) {
                sum += (q+1) * lastCnt;
                continue;
            }

            Long oldValue = countMap.get(oldKey);
            if (oldValue == 1) {
                countMap.remove(oldKey);
            } else {
                countMap.put(oldKey, oldValue - 1);
            }

            Long newValue = countMap.get(newKey);
            if(newValue == null) {
                newValue = 1l;
            }else {
                newValue = newValue + 1;
            }
            countMap.put(newKey, newValue);

            lastCnt = getCntFromArray(A, countMap);
//            System.out.println("===>" + (lastCnt/(q+1)));
            sum += (q+1) * lastCnt;
        }
        return (int)(sum % 1000000007);

    }

    static long getCntFromArray(long[] array, SortedMap<Long, Long> countMap) {
        long cnt = 0;

        Set<Long> keySet = countMap.keySet();

        Iterator<Long> iterator = keySet.iterator();

        long current = iterator.next();
        long currentCnt = countMap.get(current);
        long localCnt = currentCnt;

        while (iterator.hasNext()) {
            long next = iterator.next();
            long nextCount = countMap.get(next);

            if(next - current == 1) {
                if(currentCnt < nextCount) {
                    localCnt += (nextCount - currentCnt);
                }
                currentCnt = nextCount;
            } else {
                cnt += localCnt;
                currentCnt = nextCount;
                localCnt = currentCnt;
            }
            current = next;
//            System.out.println(localCnt + ", " + currentCnt);


        }
        cnt += localCnt;
        return cnt;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] A = new long[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextLong();
        }

        int q = in.nextInt();
        long[][] queries = new long[q][2];
        for(int queries_i = 0; queries_i < q; queries_i++){
            for(int queries_j = 0; queries_j < 2; queries_j++){
                queries[queries_i][queries_j] = in.nextLong();
            }
        }
        long result = arrayAndQueries(A, queries);

        System.out.println(result);
        in.close();
    }
}
