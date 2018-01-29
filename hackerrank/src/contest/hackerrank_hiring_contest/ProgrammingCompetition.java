package contest.hackerrank_hiring_contest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kenvi on 2018/1/27.
 */
public class ProgrammingCompetition {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Score[] scoreList = new Score[n];
        for(int a0 = 0; a0 < n; a0++){
            String name = in.next();
            int d = in.nextInt();
            int j = in.nextInt();
            scoreList[a0] = new Score(name, a0, j-d);
        }

        Arrays.sort(scoreList);
        System.out.println(scoreList[0].name +" " + scoreList[0].num);

        in.close();
    }

    private static class Score implements Comparable<Score>{
        String name;
        int order;
        int num;

        public Score(String name, int order, int num) {
            this.name = name;
            this.order = order;
            this.num = num;
        }

        @Override
        public int compareTo(Score o) {
            if (this.num == o.num) return this.order - o.order;
            return -(this.num - o.num);
        }
    }
}
