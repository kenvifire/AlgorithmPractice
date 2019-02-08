package Leecode;

public class Prob_836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x11 = rec1[0], y11 = rec1[1], x12 = rec1[2], y12 = rec1[3];
        int x21 = rec2[0], y21 = rec2[1], x22 = rec2[2], y22 = rec2[3];

        return !(x11 >= x22 || x12 <= x21 || y12 <= y21 || y11 >= y22);

    }
}
