package Leecode.google;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob737 {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        Map<String, Integer> indexMap = new HashMap<>();
        if(words1.length != words2.length) return false;

        int index = 0;
        for(List<String> pair : pairs) {
            indexMap.putIfAbsent(pair.get(0), index++);
            indexMap.putIfAbsent(pair.get(1), index++);
        }

        int n = index;
        int[] uf = new int[n];

        for(int i = 0; i < n; i++) uf[i] = i;

        for(List<String> pair : pairs) {
            int p = indexMap.get(pair.get(0));
            int q = indexMap.get(pair.get(1));
            connect(uf, p, q);
        }

        for(int i = 0; i < words1.length; i ++) {
            int p = indexMap.getOrDefault(words1[i], -1);
            int q = indexMap.getOrDefault(words2[i], -1);
            if((p!= q) && (p < 0 || q < 0 || !isConnected(uf, p, q))) return false;
        }
        return true;

    }

    int find(int[] uf, int p) {
        while(uf[p] != p) p = uf[p];
        return p;

    }

    void connect(int[] uf, int p, int q) {
        int pRoot = find(uf, p);
        int qRoot = find(uf, q);
        uf[pRoot] = qRoot;

    }

    boolean isConnected(int[] uf, int p, int q){
        return find(uf, p) == find(uf, q);
    }
}
