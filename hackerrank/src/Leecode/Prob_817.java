package Leecode;

import lib.ListNode;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob_817 {
    static class Point implements Comparable<Point> {
        int val, pos;
        public Point(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }

        @Override
        public int compareTo(Point that) {
            return this.pos - that.pos;
        }
    }
    public int numComponents(ListNode head, int[] G) {
        if(G.length <= 0) return 0;
        Map<Integer, Integer> posMap = new HashMap<>();

        ListNode p = head;
        int pos = 0;
        while (p != null) {
            posMap.put(p.val, pos);
            pos++;
            p=p.next;
        }

        List<Point> pointList = new ArrayList<>();
        for (int g : G) {
            pointList.add(new Point(g, posMap.get(g)));
        }
        Collections.sort(pointList);

        int cnt = 1;

        for (int i = 0; i< pointList.size() -1 ;i++) {
            Point cur = pointList.get(i);
            Point next = pointList.get(i + 1);
            if(cur.pos + 1 != next.pos) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Prob_817 prob = new Prob_817();
        ListNode root = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        prob.numComponents(root, new int[]{0, 3, 1, 4});
    }
}
