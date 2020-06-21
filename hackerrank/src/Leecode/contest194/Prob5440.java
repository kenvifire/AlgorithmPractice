package Leecode.contest194;

public class Prob5440 {
    public int xorOperation(int n, int start) {
        int sum = start;

        for(int i = 1; i < n; i++) {
            sum ^= start + 2 * i;
        }
        return sum;
    }
}
