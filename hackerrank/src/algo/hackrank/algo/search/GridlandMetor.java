package algo.hackrank.algo.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kenvi on 2018/1/6.
 */
public class GridlandMetor {

    static class Track implements Comparable<Track> {
        int row;
        int start, end;

        public Track(int row, int start, int end) {
            this.row = row;
            this.start = start;
            this.end = end;
        }

        public int compareTo(Track other) {
            if(this.row == other.row) {
                return this.start - other.start;
            }

            return this.row - other.row;
        }

        public void merge(Track other) {
            this.start = this.start <= other.start ? this.start : other.start;
            this.end = this.end >= other.end ? this.end : other.end;
        }

        public boolean isOverlap(Track other) {
            return (this.row == other.row) && ((this.start <= other.start && this.end >= other.start)
                    || (other.start <= this.start && other.end >= this.start));
        }

        public String toString() {
            return "row:" + row +"(" + start+"," + end +")";
        }
    }

    static long gridlandMetro(int n, int m, int k, int[][] track) {
        // Complete this function

        List<Track> trackList = new ArrayList<Track>();

        for(int i = 0; i < k; i++) {
            trackList.add(new Track(track[i][0], track[i][1], track[i][2]));
        }

        Collections.sort(trackList);
        long cnt = 0;
        for(int i = 0; i < k; i++) {
            Track curr = trackList.get(i);

            while(i < k-1 && curr.isOverlap(trackList.get(i+1))) {
                curr.merge(trackList.get(i+1));
                i++;
            }
            if(curr.end < curr.start) {
                throw new RuntimeException("");
            }
            cnt += (curr.end - curr.start + 1);
        }
        return (long)(m)*n - cnt;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] track = new int[k][3];
        for(int track_i = 0; track_i < k; track_i++){
            for(int track_j = 0; track_j < 3; track_j++){
                track[track_i][track_j] = in.nextInt();
            }
        }
        long result = gridlandMetro(n, m, k, track);
        System.out.println(result);
        in.close();
    }
}
