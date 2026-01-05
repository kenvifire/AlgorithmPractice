package Leecode;

public class Prob400 {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;
        while(n > len * count) {
            n-=  (len * count);
            count *= 10;
            start *= 10;
            len++;
        }
        start += (n-1)/len;
        String s = String.valueOf(start);
        return s.charAt((n-1) % len) - '0';
    }

    public static void main(String[] args) {
        Prob400 prob400 = new Prob400();
        for (int i = 1; i < 100; i++) {
            System.out.printf("%d, %d\n", i, prob400.findNthDigit(i));
        }
    }
}
