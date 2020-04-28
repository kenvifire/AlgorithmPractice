package Leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/evaluate-division/
 */
public class Prob399 {
    static class Edge {
        String from, to;
        double weight;

        Edge(String from, String to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    double result = -1.0f;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> graph = new HashMap<>();
        Set<String> numSet = new HashSet<String>();

        for(int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double weight = values[i];
            buildEdges(graph, from, to, weight);
            numSet.add(to);
            numSet.add(from);
        }
        double[] results = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String from = query.get(0);
            String to = query.get(1);
            result = -1.0f;
            if(!numSet.contains(from) || !numSet.contains(to)) {
                results[i] = -1.0f;
                continue;
            }
            Map<String, Boolean> visited = new HashMap<>();
            dfs(graph, visited, from, to, 1.0f);
            results[i] = result;
        }

        return results;
    }

    private void dfs(Map<String, List<Edge>> graph, Map<String, Boolean> visited, String curr, String target, double value) {
        if(curr.equals(target)) {
            result = value;
            return;
        }

        visited.put(curr, true);
        for(Edge edge: graph.getOrDefault(curr, new ArrayList<Edge>())) {
            if(!visited.getOrDefault(edge.to, false)) {
                dfs(graph, visited, edge.to, target, value * edge.weight);
            }
        }

    }

    private void buildEdges(Map<String, List<Edge>> graph, String from, String to, double weight) {
        Edge edgeFrom = new Edge(from, to, weight);
        List<Edge> listFrom = graph.getOrDefault(from, new ArrayList<Edge>());
        listFrom.add(edgeFrom);
        graph.put(from, listFrom);

        Edge edgeTo = new Edge(to, from, 1.0/weight);
        List<Edge> listTo = graph.getOrDefault(to, new ArrayList<Edge>());
        listTo.add(edgeTo);
        graph.put(to, listTo);
    }
}
