package Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prob_830 {
    static class Point implements Comparable<Point> {
        Integer[] pos;
        char ch;

        Point(Integer x, Integer y, char ch) {
            this.pos = new Integer[] {x, y};
            this.ch = ch;
        }

        @Override
        public int compareTo(Point o) {
            return this.ch - o.ch;
        }
    }

    public List<List<Integer>> largeGroupPositions(String S) {
        if(S.length() == 0) return Collections.emptyList();
        int start = 0;
        int end = 0;
        char ch = S.charAt(0);
        int cnt = 1;
        List<Point> pointList = new ArrayList<>();
        for (int i = 1; i < S.length(); i++ ) {
            if(S.charAt(i) == ch) {
                end++;
                cnt++;
            } else {
                if(cnt >= 3) {
                    pointList.add(new Point(start, end, ch));
                }
                start = i;
                end = i;
                ch = S.charAt(i);
                cnt = 1;
            }
        }
        if(cnt >= 3) {
            pointList.add(new Point(start, end, ch));
        }

        Collections.sort(pointList);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < pointList.size(); i++) {
            result.add(Arrays.asList(pointList.get(i).pos));
        }

        return result;

    }

}
