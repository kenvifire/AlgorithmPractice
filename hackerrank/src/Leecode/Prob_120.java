package Leecode;

import java.util.Arrays;
import java.util.List;

public class Prob_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 0) return 0;
        int[] result = new int[triangle.get(n - 1).size()];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        result[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            int prev = result[0];
            result[0] += triangle.get(i).get(0);
            for (int j = 1; j < triangle.get(i).size(); j++) {
                int curr = triangle.get(i).get(j);
                int temp = result[j];
                if(j == triangle.get(i).size() - 1) {
                    result[j] = curr + prev;
                } else {
                    result[j] = curr + Math.min(prev, result[j]);
                }
                prev = temp;

            }
        }

        return Arrays.stream(result).min().getAsInt();
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3,4),
                Arrays.asList(6,5,7),
                Arrays.asList(4,1,8,3)
        );

        Prob_120 prob = new Prob_120();
        System.out.println(prob.minimumTotal(result));

    }
}
