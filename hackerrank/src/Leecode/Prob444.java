package Leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Prob444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();
        Set<Integer> keySet = new HashSet<>();

        for(List<Integer> seq: seqs) {
            for(int i = 0; i < seq.size() - 1; i++) {
                int x = seq.get(i);
                int y = seq.get(i+1);

                Set<Integer> setX = graph.getOrDefault(x, new HashSet<>());
                setX.add(y);
                graph.put(x, setX);

                int out = outdegree.getOrDefault(x, 0);
                outdegree.put(x, out+1);

                int in = indegree.getOrDefault(y, 0);
                indegree.put(y, in + 1);

                keySet.add(x);
                keySet.add(y);
            }
            if(!seq.isEmpty())
                keySet.add(seq.get(seq.size() - 1));
        }
        if(org.length != keySet.size() ) {
            return false;
        }

        for(int o : org) {
            if(!keySet.contains(o)) return false;
        }
        if(indegree.getOrDefault(org[0], 0) != 0) {
            return false;
        }

        if( outdegree.getOrDefault(org[org.length - 1], 0) !=0) {
            return false;
        }




        for(int i = 0; i < org.length - 1; i++) {
            int x = org[i];
            int y = org[i+1];
            if(

                    (graph.get(x) == null || !graph.get(x).contains(y))
                            ||(graph.get(x) != null && graph.get(y) != null && graph.get(x).contains(y) && graph.get(y).contains(x))

            ) return false;
        }

        return true;

    }
}
