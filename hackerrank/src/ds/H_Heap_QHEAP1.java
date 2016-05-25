import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by kenvi on 16/5/21.
 */
public class H_Heap_QHEAP1 {


     public static void main(String[] args){
          Scanner scanner = new Scanner(System.in);

          int Q = scanner.nextInt();
          int type,v;
          PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
          while(Q --> 0) {
              type = scanner.nextInt();
              if (type == 1 || type == 2)  {
                  v = scanner.nextInt();
                  if(type == 1) {
                      queue.add(v);
                  }else {
                      queue.remove(v);
                  }
              }else {
                  System.out.println(queue.peek());
              }

          }
     }




}
