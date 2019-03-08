package Leecode;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob_797 {
    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfsPaths(new ArrayList<Integer>(), graph, 0, graph.length - 1);
        return paths;

    }

    private void dfsPaths(List<Integer> path, int[][] graph, int current, int dest) {
        path.add(current);
        if(current == dest) {
            paths.add(path);
            return ;
        }

        for (Integer node: graph[current]) {
            List<Integer> copyPath = new ArrayList<>(path);
            dfsPaths(copyPath, graph, node, dest);
        }

    }

    public static void main(String[] args) {
        Prob_797 prob = new Prob_797();
        PrintUtils.printIntListList(prob.allPathsSourceTarget(new int[][]{{1,2}, {3}, {3}, {}}));
    }
}
