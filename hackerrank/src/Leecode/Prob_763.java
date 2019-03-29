package Leecode;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob_763 {
    static class Point implements Comparable<Point> {
        int start = -1;
        int end = -1;

        public void update(int pos) {
            if(start == -1) {
                start = pos;
                end = pos;
            } else {
                end = pos;
            }
        }


        @Override
        public int compareTo(Point that) {
            if(this.start == that.start) {
                return this.end - that.end;
            }

            return this.start - that.start;
        }
    }

    public List<Integer> partitionLabels(String S) {
        Map<Character, Point> charMap = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            Point point = charMap.getOrDefault(ch, new Point());
            point.update(i);
            charMap.put(ch, point);
        }

        List<Point> pointList = new ArrayList<>(charMap.values());

        Collections.sort(pointList);

        List<Integer> result = new ArrayList<>();

        int start = pointList.get(0).start, end = pointList.get(0).end;
        for (int i = 1; i < pointList.size(); i++){
            Point point = pointList.get(i);
            if(point.start < end) {//intersect
                if(point.end > end) {
                    end = point.end;
                }
            } else {
                result.add(end - start + 1);
                start = point.start;
                end = point.end;
            }
        }
        result.add(end - start + 1);
        return result;
    }

    public static void main(String[] args) {
        PrintUtils.printIntList(new Prob_763().partitionLabels("ababcbacadefegdehijhklij"));
        PrintUtils.printIntList(new Prob_763().partitionLabels("abcd"));
    }
}
