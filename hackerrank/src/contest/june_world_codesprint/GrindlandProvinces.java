package contest.june_world_codesprint;



import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by hannahzhang on 16/6/26.
 */
public class GrindlandProvinces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int P = scanner.nextInt();

        int N = 0;
        String[] cities = new String[2];
        while (P-- > 0) {
            N = scanner.nextInt();
            scanner.nextLine();
            cities[0] = scanner.nextLine();
            cities[1] = scanner.nextLine();

            Point s = new Point();
            s.x = 0;
            s.y = 0;
            DepthFirstPaths dfs = new DepthFirstPaths(cities, N, s);

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < N; j++) {
                    Point p = new Point();
                    p.x = i;
                    p.y = j;
                    for (Point path :dfs.pathTo(p) ) {
                        System.out.print(cities[path.x].charAt(path.y));
                    }
                }
            }

        }

    }

    static class Point{
        int x,y;

        boolean eq(Point p) {
            return p.x == x &&
                    p.y == y;
        }
    }

    static class DepthFirstPaths {
        private boolean[] marked;    // marked[v] = is there an s-v path?
        private Point[] edgeTo;        // edgeTo[v] = last edge on s-v path
        private final Point s;         // source vertex
        private int N;

        public DepthFirstPaths(String[] G, int N, Point s) {
            this.s = s;
            edgeTo = new Point[2 * N];
            marked = new boolean[2 * N];
            this.N = N;
            dfs(G, s);
        }

        // depth first search from v
        private void dfs(String[] G, Point v) {
            marked[v.x*N + v.y] = true;
            for (Point w : adj(v)) {
                if (!marked[w.x * N + w.y]) {
                    edgeTo[w.x * N + w.y] = v;
                    dfs(G, w);
                }
            }
        }

        private ArrayList<Point> adj(Point v) {
            ArrayList<Point> adjList = new ArrayList<>();

            if(v.x - 1 > 0 ) {
                Point p = new Point();
                p.x = v.x - 1;
                p.y = v.y;
                adjList.add(p);
            }

            if(v.x + 1 < 2) {
                Point p = new Point();
                p.x = v.x + 1;
                p.y = v.y;
                adjList.add(p);
            }

            if(v.y -1 > 0) {
                Point p = new Point();
                p.x = v.x;
                p.y = v.y - 1;
                adjList.add(p);
            }

            if(v.y + 1 < N-1) {
                Point p = new Point();
                p.x = v.x;
                p.y = v.y +1;
                adjList.add(p);

            }

            return adjList;

        }

        public boolean hasPathTo(Point v) {
            return marked[v.x * N + v.y];
        }

        public Iterable<Point> pathTo(Point v) {
            if (!hasPathTo(v)) return null;
            Stack<Point> path = new Stack<Point>();
            for (Point x = v; !x.eq(s); x = edgeTo[x.x * N + x.y])
                path.push(x);
            path.push(s);
            return path;
        }
    }


}
