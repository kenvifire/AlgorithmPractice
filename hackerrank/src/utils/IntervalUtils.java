package utils;

import com.google.gson.Gson;
import lib.Interval;

public class IntervalUtils {
    public static Interval[] fromString(String str) {
       int[][] array = new Gson().fromJson(str, int[][].class);
       Interval[] intervals = new Interval[array.length];

       int index = 0;
       for (int[] arr : array) {
          intervals[index]  = new Interval(arr[0], arr[1]);
          index++;
       }
       return intervals;
    }

    public static String toString(Interval[] intervals) {
        int[][] array = new int[intervals.length][2];

        for (int i = 0; i < intervals.length; i++){
            array[i][0] = intervals[i].start;
            array[i][1] = intervals[i].end;
        }
        return new Gson().toJson(array);
    }

}
