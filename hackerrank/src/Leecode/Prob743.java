package Leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/network-delay-time/
 * Tag: ["Single Source Shortest Path"]
 */
public class Prob743 {
    static class Edge implements Comparable<Edge> {
        private int w, v, weight;
        Edge(int w, int v, int weight) {
            this.w = w;
            this.v = v;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }

    }

    static class Point implements Comparable<Point> {
        private int x, dist;
        Point(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }

        public int compareTo(Point other) {
            return this.dist - other.dist;
        }

        public boolean equals(Object p) {
            Point other = (Point)p;
            return this.x == other.x;
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        int MAX = 6000 * 1000;

        for(int[] time : times) {
            int x = time[0];
            int y = time[1];
            int weight = time[2];
            Edge edge = new Edge(x, y, weight);

            List<Edge> linkX = graph.getOrDefault(x, new ArrayList<Edge>());
            linkX.add(edge);
            graph.put(x, linkX);
        }


        int[] distTo = new int[N + 1];

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i = 0; i <= N; i++) distTo[i] = MAX;

        distTo[K] = 0;

        pq.add(new Point(K, 0));

        while(!pq.isEmpty()) {
            Point p = pq.poll();
            for(Edge edge : graph.getOrDefault(p.x, Collections.emptyList())) {
                relax(graph, edge, distTo, pq);
            }
        }
        int max = -1;
        for(int i = 1; i <= N; i++) {
            System.out.printf("[%d]%d\n", i, distTo[i]);
            if(distTo[i] >= MAX) return -1;
            if(distTo[i] > max) max = distTo[i];
        }
        return max;

    }

    private void relax(Map<Integer, List<Edge>> graph, Edge edge, int[] distTo,
                       PriorityQueue<Point> pq) {
        int to = edge.v;
        int from = edge.w;

        if(distTo[to] > distTo[from] + edge.weight) {
            distTo[to] = distTo[from] + edge.weight;
            if(pq.contains(to)) {
                pq.remove(new Point(to, 0));
            }
            pq.add(new Point(to, distTo[to]));
        }

    }
}
