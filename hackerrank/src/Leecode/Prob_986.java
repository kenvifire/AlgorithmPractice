package Leecode;

import lib.Interval;
import utils.AssertUtils;
import utils.IntervalUtils;

import java.util.ArrayList;
import java.util.List;

public class Prob_986 {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> temp = new ArrayList<>();
        int a = 0, b = 0;
        while (a < A.length && b < B.length) {
            Interval intelA = A[a];
            Interval intelB = B[b];

            Interval intersect = getIntersect(intelA, intelB);
            if(intersect == null) {
                if(intelA.end < intelB.start) {
                    a++;
                } else {
                    b++;
                }
            } else {
                temp.add(intersect);
                if(intelA.end < intelB.end)  {
                    a++;
                } else if (intelB.end < intelA.end){
                    b++;
                } else {
                    a++;
                    b++;
                }
            }

        }

        Interval[] result = new Interval[temp.size()];
        temp.toArray(result);
        return result;
    }

    private Interval getIntersect(Interval A, Interval B) {
        int start = Math.max(A.start, B.start);
        int end = Math.min(A.end, B.end);

        if(start <= end) return new Interval(start, end);

        return null;
    }

    public static void main(String[] args) {
        Prob_986 prob = new Prob_986();
        AssertUtils.equals("[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]",
                IntervalUtils.toString(prob.intervalIntersection(IntervalUtils.fromString("[[0,2],[5,10],[13,23],[24,25]]"),
                        IntervalUtils.fromString("[[1,5],[8,12],[15,24],[25,26]]"))));
    }

}
