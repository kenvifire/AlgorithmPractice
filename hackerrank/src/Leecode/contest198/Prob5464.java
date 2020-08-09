package Leecode.contest198;

public class Prob5464 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        int current = numBottles;
        while (current >= numExchange) {
            int exchange = current / numExchange;
            total += exchange;
            current = exchange + current % numExchange;

        }
        return total;


    }
}
