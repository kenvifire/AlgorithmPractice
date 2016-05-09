import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by hannahzhang on 16/5/9.
 */
public class H_Queue_JesseAndCookies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer>  pq = new PriorityQueue<Integer>();

        int N = scanner.nextInt();

        int K = scanner.nextInt();
        int s;
        while(N --> 0) {
            s = scanner.nextInt();
            pq.add(s);
        }
        int first,second, result;
        int cnt = 0;
        while (pq.size() > 1 && pq.peek() < K) {
            first = pq.remove();
            second = pq.remove();
            result = first + 2 * second;
            pq.add(result);
            cnt++;
        }
        if(pq.peek() >= K) {
            System.out.print(cnt);
        }else {
            System.out.print(-1);
        }






    }
}
