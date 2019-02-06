package Leecode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob_447 {
    static class PointDistance implements Comparable<PointDistance> {
        int[] origin;
        int[] current;
        int distance;

        PointDistance(int[] origin, int[] current) {
            this.origin = origin;
            this.current = current;
            this.distance = (origin[0] - current[0]) * (origin[0] - current[0]) +
                    (origin[1] - current[1]) * (origin[1] - current[1]);
        }


        @Override
        public int compareTo(PointDistance o) {
            if(origin[0] == o.origin[0] && origin[1] == o.origin[1]) {
                if(distance != o.distance) {
                    return distance - o.distance;
                } else {
                    return 0;
                }
            } else if(origin[0] != o.origin[0]) {
                return origin[0] - o.origin[0];
            } else {
                if(origin[1] != origin[1]) {
                    return origin[1] - current[1];
                } else {
                    return 0;
                }
            }


        }
    }
    public int numberOfBoomerangs(int[][] points) {
        if(points.length <= 2) return 0;
        List<PointDistance> pdList = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if(i != j) {
                    pdList.add(new PointDistance(points[i], points[j]));
                }
            }

        }

        Collections.sort(pdList);

        int[] currOrign = pdList.get(0).origin;
        int distance =  pdList.get(0).distance;
        int currCnt = 1;
        int toalCnt = 0;
        for (int i = 1; i < pdList.size(); i++) {
            PointDistance pd = pdList.get(i);

            if(pd.origin[0] == currOrign[0] && pd.origin[1] == currOrign[1] && distance == pd.distance) {
                currCnt ++;
            } else {
                if(currCnt > 1) {
                    toalCnt += currCnt * (currCnt - 1);
                }

                currOrign = pd.origin;
                currCnt = 1;
                distance = pd.distance;
            }
        }

        if(currCnt > 1) {
            toalCnt += currCnt * (currCnt - 1);
        }

        return toalCnt;
    }

    public static void main(String[] args) {
        System.out.println(new Prob_447().numberOfBoomerangs(new int[][] {{1,8},{7,9},{2,0},{2,3},{7,5},{9,2},{2,8},{9,7},{3,6},{1,2}}));
        System.out.println(new Prob_447().numberOfBoomerangs(new int[][] {{0, 0}, {1, 0}}));
        System.out.println(new Prob_447().numberOfBoomerangs(new int[][] {{0, 0}, {1, 0}, {2, 0}}));
        System.out.println(new Prob_447().numberOfBoomerangs(new int[][] {{-1, 0}, {0, 0}, {1,0}, {0,1}}));
        System.out.println(new Prob_447().numberOfBoomerangs(new int[][] {{-1, 0}, {0, 0}, {1,0}, {0,1}, {0,-1}}));

    }
}
