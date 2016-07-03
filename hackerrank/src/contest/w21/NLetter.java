package contest.w21;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/7/2.
 */
public class NLetter {
    static class Point{
        int x,y;

        @Override
        public boolean equals(Object obj) {
            Point p = (Point)obj;
            if(p.x == this.x && p.y == this.y) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            Point p = new Point();
            p.x = scanner.nextInt();
            p.y = scanner.nextInt();

            points[i] = p;
        }


        long total = 0;
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N ; j++) {
                Point B = points[i];
                Point C = points[j];
                if(B.equals(C)) continue;
                int leftCnt = 0;
                int rightCnt = 0;

                for (int k = 0; k < N; k++) {
                    if(k != i && k != j) {
                        if(B.equals(points[k]) || C.equals(points[k])) continue;

                        double angleABC = AngleBetween(points[k], B, C);
                        double angleBCD = AngleBetween(B, C, points[k]);
//                        System.out.println(String.format("Point A{%s,%s},B{%s,%s},C {%s,%s},angle:%s",points[k].x,
//                                points[k].y,B.x,B.y,C.x,C.y, angleABC * (180/Math.PI)));
//                        System.out.println(String.format("Point B{%s,%s},C{%s,%s},D {%s,%s},angle:%s",B.x,
//                                B.y,C.x,C.y,points[k].x, points[k].y, angleDBC *(180/Math.PI)));
                        if (angleABC <  Math.PI/2 && angleABC > 0) {
//                            System.out.println("left");
                            leftCnt++;
                        }else if(angleBCD < 0 && angleBCD > -Math.PI/2) {
                            rightCnt++;
//                            System.out.println("right");
                        }

                    }
//                    System.out.println("===========trying point " + k +"============");

                }

//                System.out.println(String.format("Point B {%s,%s},C {%s,%s}: left %s, right %s", B.x, B.y, C.x, C.y,leftCnt, rightCnt));
                total += leftCnt * rightCnt;

            }
        }
        System.out.println(total);
    }



    private static double angle(Point A, Point B, Point C) {
        double angle1,angle2;
        if(A.x == B.x ) {
            if(A.y > B.y) {
                angle1 = Math.PI/2;
            }else {
                angle1 = -Math.PI/2;
            }
        }else {
            double k1 = (A.y - B.y) / (A.x - B.x);
            angle1 = Math.atan(k1);
        }

        if(C.x == B.x ) {
            if(C.y > B.y) {
                angle2 = Math.PI/2;
            }else {
                angle2 = -Math.PI/2;
            }
        }else {
            double k2 = (C.y - B.y) / (C.x - B.x);
            angle2 = Math.atan(k2);
        }
        return angle2 - angle1;
    }
    public static double AngleBetween(Point A, Point B, Point C)
    {

        Point vector1 = new Point();
        vector1.x = A.x - B.x;
        vector1.y = A.y - B.y;

        Point vector2 = new Point();
        vector2.x = C.x - B.x;
        vector2.y = C.y - B.y;
        double sin = vector1.x * vector2.y - vector2.x * vector1.y;
        double cos = vector1.x * vector2.x + vector1.y * vector2.y;

        return Math.atan2(sin, cos);
    }

}
