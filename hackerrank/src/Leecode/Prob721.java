package Leecode;

import java.util.*;

public class Prob721 {
    Map<String, List<String>> graph;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        graph = new HashMap<>();
        Map<String, String> accountmap = new HashMap<>();
        for (List<String> account: accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String from = account.get(i);
                accountmap.put(from, name);
                graph.computeIfAbsent(from, k -> new ArrayList<>());
                if(i < account.size() - 1) {
                    String to = account.get(i + 1);
                    graph.computeIfAbsent(to, k -> new ArrayList<>());
                    accountmap.put(to, name);

                    graph.get(from).add(to);
                    graph.get(to).add(from);
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (String from: graph.keySet()) {
            if(!visited.contains(from)){
                List<String> rs = new ArrayList<>();
                bfs(visited, from, rs);
                Collections.sort(rs);
                List<String> temp = new ArrayList<>();
                temp.add(accountmap.get(from));
                temp.addAll(rs);
                result.add(temp);
            }
        }
        return result;

    }

    public void bfs(Set<String> visited, String node, List<String> rs) {
        rs.add(node);
        visited.add(node);
        for (String to: graph.get(node)) {
            if (!visited.contains(to)) {
                bfs(visited, to, rs);
            }
        }

    }

    public static void main(String[] args) {
        Prob721 p = new Prob721();
        List<List<String>> accounts = Arrays.asList(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),
                Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),
                Arrays.asList("Mary","mary@mail.com"),
                Arrays.asList("John","johnnybravo@mail.com"));
        System.out.println(p.accountsMerge(accounts));
    }
}
