package lib;


/**
 * Created by hannahzhang on 16/7/3.
 */
public class VectorAngle {
    public static void main(String[] args) {
        Point A = new Point();
        A.x = 2;
        A.y = 2;
        Point B = new Point();
        B.x = 0;
        B.y = 2;
        Point C = new Point();
        C.x = 2;
        C.y = 0;
        Point D = new Point();
        D.x = 2;
        D.y = 2;
        System.out.println(AngleBetween(A,B,C) * (180 / Math.PI));
        System.out.println(AngleBetween(B,C,A) * (180 / Math.PI));
    }

    static class Point{
        int x,y;

        @Override
        public boolean equals(Object obj) {
            Point p = (Point)obj;
            if(p.x == this.x && p.y == this.y) return true;
            return false;
        }
    }

    public static double AngleBetween(Point a, Point b, Point c)
    {

        Point vector1 = new Point();
        vector1.x = a.x - b.x;
        vector1.y = a.y - b.y;

        Point vector2 = new Point();
        vector2.x = c.x - b.x;
        vector2.y = c.y - b.y;
        double sin = vector1.x * vector2.y - vector2.x * vector1.y;
        double cos = vector1.x * vector2.x + vector1.y * vector2.y;

        return Math.atan2(sin, cos);
    }
}
