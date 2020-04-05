package Leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/regions-cut-by-slashes/
 */
public class Prob959 {
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        boolean[] visited = new boolean[N * N * 4];
        List<List<Integer>> graph = new ArrayList<>(N * N * 4);

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j< N; j++) {
                boolean leftCut = grid[i].charAt(j) == '/';
                boolean rightCut = grid[i].charAt(j) == '\\';

                int left = 4 * ( N * i + j);
                int up = left + 1;
                int right = up + 1;
                int down = right + 1;
                //left
                List<Integer> leftLink = new ArrayList<>();
                if(j > 0) {
                    leftLink.add(left - 2);
                }
                if(!rightCut){
                    leftLink.add(up);
                }
                if(!leftCut) {
                    leftLink.add(down);
                }
                graph.add(leftLink);
                //up
                List<Integer> upLink = new ArrayList<>();
                if(i > 0) {
                    upLink.add(up - 4 * N + 2);
                }
                if(!rightCut) {
                    upLink.add(left);
                }
                if(!leftCut)  {
                    upLink.add(right);
                }

                graph.add(upLink);
                //right
                List<Integer> rightLink = new ArrayList<>();
                if(j < N - 1) {
                    rightLink.add(right+2);
                }
                if(!leftCut) {
                    rightLink.add(up);
                }
                if(!rightCut){
                    rightLink.add(down);
                }
                graph.add(rightLink);

                //down
                List<Integer> downLink = new ArrayList<>();
                if(i < N - 1) {
                    downLink.add(down + 4 * N -2);
                }
                if(!leftCut){
                    downLink.add(left);
                }
                if(!rightCut){
                    downLink.add(right);
                }
                graph.add(downLink);

            }

        }


        int components = 0;

        for(int i = 0; i < N; i++ ) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < 4; k++ ) {
                    int node = 4 * ( i * N + j) + k;
                    if(!visited[node]) {
                        dfs(visited, graph, node);
                        components ++;
                    }
                }
            }
        }

        return components;
    }

    void dfs(boolean[] visited, List<List<Integer>> graph, int curr) {
        if(visited[curr]) return;
        visited[curr] = true;
        for(int node : graph.get(curr)) {
            if(!visited[node]) {
                dfs(visited, graph, node);
            }
        }
    }



    public int regionsBySlashes_UF(String[] grid) {
        int N = grid.length;
        int[] uf = new int[4 * N * N];
        for(int i = 0 ; i < 4 * N * N; i++) uf[i] = i;

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j< N; j++) {
                boolean leftCut = grid[i].charAt(j) == '/';
                boolean rightCut = grid[i].charAt(j) == '\\';
                int left = 4 * ( N * i + j);
                int up = left + 1;
                int right = up + 1;
                int down = right + 1;

                //left
                if(j > 0) {
                    connect(uf, left, left - 2);
                }
                //up
                if(i > 0) {
                    connect(uf, up, up - 4 * N + 2);
                }
                //right
                if(j < N - 1) {
                    connect(uf, right, right + 2);
                }
                if( i < N -1) {
                    connect(uf, down, down + 4 * N -2);
                }

                if(!leftCut) {//not "/"
                    connect(uf, left, down);
                    connect(uf, right, up);
                }

                if(!rightCut) {//not "\\"
                    connect(uf, left, up);
                    connect(uf, right, down);
                }

            }

        }


        int components = 0;

        for(int i = 0; i < 4 * N *N; i++ ) {
            if(find(uf, i) == i) {components ++;}
        }

        return components;
    }

    private void connect(int[] uf, int p, int q) {
        int rootP = find(uf, p);
        int rootQ = find(uf, q);
        uf[rootP] = rootQ;
    }

    private int find(int[] uf, int p) {
        while(p != uf[p]) p = uf[p];
        return p;
    }
}
