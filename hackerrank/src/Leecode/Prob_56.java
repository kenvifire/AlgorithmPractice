package Leecode;

import lib.Interval;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Prob_56 {
    public List<Interval> merge(List<Interval> intervals)  {
        if(intervals.size() <= 1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                if(interval1.start == interval2.start) {
                    return interval1.end - interval2.end;
                } else {
                    return interval1.start - interval2.start;
                }
            }
        });
        List<Interval> result = new ArrayList<>();
        Interval current = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval temp = intervals.get(i);
            if(current.end >= temp.start) {
                current.end = Math.max(current.end, temp.end);
            } else {
                result.add(current);
                current = intervals.get(i);
            }
        }
        result.add(current);
        return result;
    }




}
