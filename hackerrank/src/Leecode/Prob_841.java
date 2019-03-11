package Leecode;

import java.util.BitSet;
import java.util.List;

public class Prob_841 {
    int cnt;
    BitSet bs;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        cnt = 0;
        bs = new BitSet(rooms.size() + 1);

        dfs(rooms, 0);
        return  cnt >= rooms.size();

    }

    public void dfs(List<List<Integer>> rooms, int current) {
        if(bs.get(current)) return;
        bs.set(current);
        cnt++;

        for (Integer room : rooms.get(current)) {
           dfs(rooms, room);
        }
    }
}
