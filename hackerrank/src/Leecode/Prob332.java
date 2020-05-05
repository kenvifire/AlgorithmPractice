package Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Prob332 {
    static class Edge implements Comparable<Edge> {
        String from, to;
        Edge(String from, String to) {
            this.from = from;
            this.to = to;
        }

        //public boolean equals(Object other) {
        //   Edge that = (Edge)other;
        //  return this.from.equals(that.from) && this.to.equals(that.to);
        //}

        // public int hashCode() {
        //     return this.from.hashCode() + this.to.hashCode();
        //}

        public int compareTo(Edge that) {
            return this.to.compareTo(that.to);
        }
        public String toString() {
            return String.format("%s->%s", this.from, this.to);
        }
    }
    List<Edge> result;
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<Edge, Boolean> visited = new HashMap<>();

        Map<String, List<Edge>> graph = new HashMap<>();
        Map<String, Integer> degreeMap = new HashMap<>();

        for(List<String> ticket: tickets) {
            String from = ticket.get(0) ;
            String to = ticket.get(1);
            List<Edge> edgeList = graph.getOrDefault(from, new ArrayList<Edge>());
            edgeList.add(new Edge(from, to));
            graph.put(from, edgeList);

            int fromDegree = degreeMap.getOrDefault(from, 0);
            degreeMap.put(from, fromDegree + 1);
            int toDegree = degreeMap.getOrDefault(to, 0);
            degreeMap.put(to, toDegree - 1);
        }

        String start = "JFK";


        dfs(graph, new Edge("", start), visited, Arrays.asList(new Edge("", start)), tickets.size());

        List<String> flights = new ArrayList<>();

        for(int i = 0; i < result.size(); i++) {
            flights.add(result.get(i).to);
        }
        return flights;

    }

    private void dfs(Map<String, List<Edge>> graph, Edge curr, Map<Edge,Boolean> visited, List<Edge> flights, int n) {
        if(flights.size() == n + 1 ) {
            result = flights;
            return;
        }
        if(result != null) return;

        List<Edge> edges = graph.getOrDefault(curr.to, null);
        if(edges== null)  return;
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.addAll(edges);

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(!visited.getOrDefault(edge, false)) {
                visited.put(edge, true);
                List<Edge> clonedFlights = clone(flights);
                clonedFlights.add(edge);
                dfs(graph, edge, visited, clonedFlights, n);
                visited.put(edge, false);
            }
        }
    }

    private List<Edge> clone(List<Edge> origin) {
        List<Edge> newList = new ArrayList<>();
        for(Edge edge : origin) newList.add(new Edge(edge.from, edge.to));
        return newList;
    }
}
