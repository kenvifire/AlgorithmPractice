package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kenvi on 16/6/14.
 */
public class H_Implementation_CavityMap {
    static class Point {
        int x, y;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder grid[] = new StringBuilder[n];
        for(int grid_i=0; grid_i < n; grid_i++){
            grid[grid_i] = new StringBuilder(in.next());
        }
        List<Point> points = new ArrayList<Point>();

        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < n-1; j++) {
                char depth = grid[i].charAt(j);
                if(depth > grid[i].charAt(j-1)
                        && depth > grid[i].charAt(j+1)
                        && depth > grid[i-1].charAt(j)
                        && depth > grid[i+1].charAt(j)) {
                    Point p = new Point();
                    p.x = i;
                    p.y = j;
                    points.add(p);
                }
            }

        }
        for (Point point : points) {
            grid[point.x].setCharAt(point.y,'X');
        }

        for (int i = 0; i < n; i++) {
           System.out.println(grid[i]);
        }
    }
}
