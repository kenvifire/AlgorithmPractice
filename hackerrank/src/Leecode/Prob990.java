package Leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob990 {
    public boolean equationsPossible(String[] equations) {
        int N = equations.length;
        int[] eqUf = new int[2 * N];
        for(int i = 0; i < 2 * N; i++) {
            eqUf[i] = i;
        }

        int idx = 0;
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        Map<Character, Integer> idxMap = new HashMap<>();
        for(String eq: equations) {
            char a = eq.charAt(0);
            char b = eq.charAt(3);
            int idxA = idxMap.getOrDefault(a, -1);
            if(idxA < 0) {
                idxA = idx++;
            }
            idxMap.put(a, idxA);
            int idxB = idxMap.getOrDefault(b, -1);
            if(idxB < 0) {
                idxB = idx++;
            }
            idxMap.put(b, idxB);

            boolean isEq = eq.charAt(1) == '=';
            if(!isEq) {
                if(a == b) {
                    return false;
                } else {
                    leftList.add(idxA);
                    rightList.add(idxB);
                }
            } else {
                connect(eqUf, idxA, idxB);
            }
        }

        for(int i = 0; i < leftList.size(); i++) {
            int a =leftList.get(i);
            int b = rightList.get(i);
            if(isConnected(eqUf, a, b)) return false;
        }
        return true;

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

    private boolean isConnected(int[] uf, int p, int q) {
        return find(uf, p) == find(uf, q);
    }
}
