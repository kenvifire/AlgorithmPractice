package Leecode;

import utils.AssertUtils;

import java.util.HashSet;
import java.util.Set;

public class Prob_874 {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj) {
            Point point = (Point)obj;
            return point.x == this.x && point.y == this.y;
        }

        @Override
        public int hashCode() {
            return this.x * 17 + this.y;
        }
    }

    private int[][] directions = new int[][] {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Point> obSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obSet.add(new Point(obstacle[0], obstacle[1]));
        }
        int x = 0, y = 0;
        int direct = 2;
        int max = 0;
        for (int command : commands) {
            if(command == -2 || command == -1) {
                direct += command == -2 ? 1 : -1;

                if(direct == -1) direct = 3;
                if(direct == 4) direct = 0;
            }


            if(command >= 1 && command <= 9) {

                Point current = canMoveTo(new Point(x, y), obSet, direct, command);
                x = current.x;
                y = current.y;
                if(x*x + y * y > max) max = x*x + y * y;

            }

        }
        return max;

    }

    private Point canMoveTo(Point current, Set<Point> obstacles, int direction, int steps) {
       for (int i = 1; i <= steps; i++) {
           Point next = new Point(current.x + directions[direction][0] * i, current.y + directions[direction][1] * i) ;
           if(obstacles.contains(next)) return new Point(current.x + directions[direction][0] * (i- 1), current.y + directions[direction][1] * (i-1));
       }
       return new Point(current.x + directions[direction][0] * steps, current.y + directions[direction][1] * steps) ;
    }

    public static void main(String[] args) {
        Prob_874 prob = new Prob_874();
        AssertUtils.equals(25, prob.robotSim(new int[]{4, -1, 3}, new int[][]{}));
        AssertUtils.equals(65, prob.robotSim(new int[]{4,-1,4,-2,4}, new int[][]{{2,4}}));
    }
}
