package ds;

/**
 * Created by kenvi on 16/5/25.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class H_Heap_MinumnAverageWaitingTime {

     static class Node implements Comparable<Node>{
         int t;
         int l;

         @Override
         public int compareTo(Node o) {
             return this.l - o.l;
         }
     }

     public static void main(String[] args){
          Scanner scanner = new Scanner(System.in);

          int N = scanner.nextInt();

          Node[] nodes = new Node[N];
          for(int s_i = 0; s_i < N; s_i++) {
               Node node = new Node();
               node.t = scanner.nextInt();
               node.l = scanner.nextInt();

               nodes[s_i] = node;
          }

          PriorityQueue<Node> pq = new PriorityQueue<Node>();
          Arrays.sort(nodes, new Comparator<Node>() {
              @Override
              public int compare(Node o1, Node o2) {
                  return o1.t - o2.t;
              }
          });
          long totalTime = 0;
          long time = nodes[0].t;
          int index = 0;
          //init
          while(index < N && nodes[index].t <=time ) {
              pq.offer(nodes[index++]);
          }

          while(!pq.isEmpty()) {
              Node min = pq.poll();
              time += min.l;
              totalTime += (time - min.t);
              //in case no customer during (time, node[index].t)
              if(index < N && time < nodes[index].t && pq.isEmpty()) {
                 time = nodes[index].t;
              }
              while(index < N && nodes[index].t <=time ) {
                  pq.offer(nodes[index++]);
              }

          }

         System.out.print(totalTime/N);


     }
}
