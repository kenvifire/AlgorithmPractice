package Leecode;

public class Prob_985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[queries.length];
        int sum = 0;

        for (int a : A) {
            if(a % 2 == 0) sum += a;
        }
        int resultIdx = 0;
        for (int[] query : queries) {
            int val = query[0];
            int idx = query[1];

            if(A[idx] % 2 == 0) {
                if(A[idx] + val %2 == 0) {
                    sum += val;
                }else {
                    sum -= A[idx];
                }
            }else {
                if((A[idx] + val % 2) == 0) {
                    sum += A[idx] + val;
                }
            }

            A[idx] += val;
            result[resultIdx++] = sum;

        }
        return result;

    }

    public static void main(String[] args) {
        Prob_985 prob = new Prob_985();
        prob.sumEvenAfterQueries(new int[] {1,2,3,4}, new int[][]{{1,0},{-3,1},{-4,0},{2,3}});
    }
}
