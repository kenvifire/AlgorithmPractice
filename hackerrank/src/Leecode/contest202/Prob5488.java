package Leecode.contest202;

public class Prob5488 {
    public int minOperations(int n) {
        int cnt = 0;

        int s = 0;
        int mid = n/2 + (n % 2);
        for (int i = 0; i <= mid ;i++) {
            s = 2 * i + 1;
            cnt +=  (n - s);
        }
        return cnt;


    }

    public static void main(String[] args) {
        Prob5488 prob5488 = new Prob5488();
        prob5488.minOperations(3);
    }
}
