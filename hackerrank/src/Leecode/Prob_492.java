package Leecode;

import utils.PrintUtils;

public class Prob_492 {
    public int[] constructRectangle(int area) {
        if (area == 0) return new int[] {0,0};
        for (int i = (int)Math.floor(Math.sqrt(area)); i > 0; i--) {
            if(area % i == 0) return new int[]{area/i, i};
        }
        return null;
    }

    public static void main(String[] args) {
        PrintUtils.printArray(new Prob_492().constructRectangle(0));
        PrintUtils.printArray(new Prob_492().constructRectangle(1));
        PrintUtils.printArray(new Prob_492().constructRectangle(2));
        PrintUtils.printArray(new Prob_492().constructRectangle(3));
        PrintUtils.printArray(new Prob_492().constructRectangle(4));
        PrintUtils.printArray(new Prob_492().constructRectangle(5));
        PrintUtils.printArray(new Prob_492().constructRectangle(6));
        PrintUtils.printArray(new Prob_492().constructRectangle(7));
        PrintUtils.printArray(new Prob_492().constructRectangle(8));
        PrintUtils.printArray(new Prob_492().constructRectangle(9));
        PrintUtils.printArray(new Prob_492().constructRectangle(10));
        PrintUtils.printArray(new Prob_492().constructRectangle(11));
        PrintUtils.printArray(new Prob_492().constructRectangle(12));
        PrintUtils.printArray(new Prob_492().constructRectangle(13));
        PrintUtils.printArray(new Prob_492().constructRectangle(14));
        PrintUtils.printArray(new Prob_492().constructRectangle(15));
        PrintUtils.printArray(new Prob_492().constructRectangle(16));
    }
}
