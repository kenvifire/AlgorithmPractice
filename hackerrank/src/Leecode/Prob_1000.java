package Leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Prob_1000 {
    public int mergeStones(int[] stones, int K) {
        if (stones.length < K ) return -1;
        int len = stones.length;
        if ((len - K) % (K - 1) != 0) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();

        int localSum = 0;
        for (int i = 0; i < K ; i++) {
           localSum += stones[i];
        }
        int index = 0;
        sumMap.put(localSum, Arrays.asList(index));
        pq.offer(localSum);
        indexMap.put(index, localSum);

        for (int i = K; i < len; i++) {
           index++;
           localSum -= stones[i - K];
           localSum += stones[i];
           List<Integer> value = sumMap.get(localSum);
           if(value == null) {
               sumMap.put(localSum, Arrays.asList(index));
           } else {
               value.add(index);
               sumMap.put(localSum, value);
           }
           pq.offer(localSum);
           indexMap.put(index, localSum);
        }

        int total = 0;
        while (!pq.isEmpty()) {
            Integer min = pq.poll();
            total += min;
            List<Integer> indexList = sumMap.get(min);
            int last = indexList.get(indexList.size() - 1);
            indexList.remove(indexList.size() - 1);
            //TODO

        }

        return -1;








    }
}
