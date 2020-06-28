package Leecode.contest195;

import java.util.HashSet;
import java.util.Set;

public class Prob5448 {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x *13 + y;
        }

        @Override
        public boolean equals(Object obj) {
            Point other = (Point) obj;
            return other.x == this.x && other.y == this.y;
        }
    }
    public boolean isPathCrossing(String path) {
        Set<Point>  set = new HashSet<>();

        int x = 0, y  = 0;
        set.add(new Point(x, y));
        for(char ch : path.toCharArray()) {
            switch (ch) {
                case 'N':
                    y +=1;
                    break;
                case 'S':
                    y -= 1;
                    break;
                case 'W':
                    x -= 1;
                    break;
                case 'E':
                    x +=1;
                    break;
            }

            Point point = new Point(x, y);
            if(set.contains(point)) {
                return true;
            } else {
                set.add(point);
            }

        }
        return false;

    }
}
