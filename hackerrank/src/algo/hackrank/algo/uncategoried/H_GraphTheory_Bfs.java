package algo.hackrank.algo.uncategoried;

import java.util.*;

/**
 * Created by kenvi on 16/6/3.
 */
public class H_GraphTheory_Bfs {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int N,M,S;
        for (int i = 0; i < T; i++){
            N = scanner.nextInt();
            M = scanner.nextInt();
            Graph g = new Graph(N, M, scanner);
            S = scanner.nextInt();
            g.bfs(S);

            for (int j = 1; j <=N; j++) {
                if( j != S) {
                    System.out.print((g.getCount(j) != 0 ? g.getCount(j)*6 : -1) + " ");
                }
            }
            System.out.println();
        }
    }

    static class Graph {
        Node[] graph;
        boolean[] marked;
        int[] pathCount;
        int count = 0;
        static class Node {
            List<Integer>  nodeList = new ArrayList<>();
        }

        public Graph(int n, int m, Scanner scanner) {
            graph = new Node[n+1];
            marked = new boolean[n+1];
            pathCount = new int[n+1];
            for (int i = 0; i <= n; i++ ) {
                graph[i] = new Node();
                marked[i] = false;
                pathCount[i] = 0;
            }
            int a,b;
            for (int i = 0; i <m; i++) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                graph[a].nodeList.add(b);
                graph[b].nodeList.add(a);
            }
        }
        public int getCount(int s) {
            return pathCount[s];
        }

        public void bfs(int s) {
            Queue<Integer> queue = new ArrayDeque<>();
            marked[s] = true;
            queue.add(s);
            pathCount[s] = 0;

            while(!queue.isEmpty()) {
                int v = queue.poll();
                for (int w : graph[v].nodeList) {
                    if(!marked[w]) {
                        marked[w] = true;
                        queue.add(w);
                        pathCount[w] = pathCount[v]+1;
                    }
                }
            }

        }



    }


}
