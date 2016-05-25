import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kenvi on 16/5/5.
 */
public class H_Dynamic_Array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<ArrayList<Integer>> seqList = new ArrayList<ArrayList<Integer>>(N);
        for(int i = 0; i< N ; i++) {
            seqList.add(new ArrayList<Integer>());
        }
        int Q = in.nextInt();
        int type, x,y;
        int lastAns = 0;
        int index;
        while( Q-->0) {
            type = in.nextInt();
            x = in.nextInt();
            y = in.nextInt();
            index = (x ^ lastAns) % N;
            ArrayList<Integer> seq = seqList.get(index);
            if(type == 1) {
                seq.add(y);
            } else if( type == 2) {
                lastAns = seq.get( y % seq.size() );
                System.out.println(lastAns);
            }



        }

    }
}
