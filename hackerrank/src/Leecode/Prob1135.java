package Leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/connecting-cities-with-minimum-cost/
 */
public class Prob1135 {
    static class Edge implements Comparable<Edge> {
        int w, v, weight;
        Edge(int w, int v, int weight) {
            this.w = w;
            this.v = v;
            this.weight = weight;
        }

        int either() {
            return this.w;
        }
        int other(int s) {
            return w == s ? v : w;
        }
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    public int minimumCost(int N, int[][] connections) {
        boolean[] visited = new boolean[N+1];
        Map<Integer, List<Edge>> graph = new HashMap<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int[] conn : connections) {
            build(graph, conn[0], conn[1], conn[2]);
        }

        visit(graph, visited, pq, 1);
        int cost = 0;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            int w = edge.either();
            int v = edge.other(w);
            if(visited[w] && visited[v]) continue;
            cost += edge.weight;

            if(!visited[w]) visit(graph, visited, pq, w);
            if(!visited[v]) visit(graph, visited, pq, v);

        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) return -1;
        }

        return cost;


    }

    private void build(Map<Integer, List<Edge>> graph, int w, int v, int weight) {
        Edge edge = new Edge(w, v, weight);

        List<Edge> linkW = graph.getOrDefault(w, new ArrayList<Edge>());
        linkW.add(edge);
        graph.put(w, linkW);

        List<Edge> linkV = graph.getOrDefault(v, new ArrayList<Edge>());
        linkV.add(edge);
        graph.put(v, linkV);
    }

    private void visit(Map<Integer, List<Edge>> graph, boolean[] visited, PriorityQueue<Edge> pq, int v) {
        visited[v] = true;
        for(Edge edge: graph.get(v)) {
            if(!visited[edge.other(v)]) {
                pq.add(edge);
            }
        }

    }
}
