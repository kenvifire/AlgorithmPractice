package Leecode;

public class Prob_812 {
    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for (int i = 0; i < points.length - 2; i++){
            for (int j = i+1; j < points.length - 1; j++){
                for (int k = j+1; k < points.length; k++) {
                    int a_x = points[i][0];
                    int a_y = points[i][1];
                    int b_x = points[j][0];
                    int b_y = points[j][1];
                    int c_x = points[k][0];
                    int c_y = points[k][1];

                    double a = Math.sqrt(Math.pow(a_x - b_x, 2) + Math.pow(a_y - b_y, 2));
                    double b = Math.sqrt(Math.pow(b_x - c_x, 2) + Math.pow(b_y - c_y, 2));
                    double c = Math.sqrt(Math.pow(a_x - c_x, 2) + Math.pow(a_y - c_y, 2));

                    double p = (a + b +c) / 2;

                    double areaSq = p * (p - a) * (p - b) * (p - c);

                    if(areaSq > 0 && areaSq > max) {
                            max = areaSq;
                    }

                }
            }
        }
        return Math.sqrt(max);
    }
}
