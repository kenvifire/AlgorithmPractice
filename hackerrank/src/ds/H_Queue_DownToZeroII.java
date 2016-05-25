import java.util.*;

/**
 * Created by kenvi on 16/5/20.
 */
public class H_Queue_DownToZeroII {
    static class Node{
        int i;
        int step=0;
    }


    public static void main(String[] args) {
        Map<Integer,Integer> resultMap = new HashMap<Integer, Integer>();
        resultMap.put(1,1);
        resultMap.put(2,2);
        Scanner scanner = new Scanner(System.in);
        int Q,N;

        Q = scanner.nextInt();


        while( Q --> 0) {
            int minStep = Integer.MAX_VALUE;
            N = scanner.nextInt();
            //find factor
            Queue<Node> queue = new ArrayDeque<Node>();
            Node nNode = new Node();
            nNode.i = N;
            nNode.step = 0;
            queue.offer(nNode);
            while (!queue.isEmpty()) {
                Node top = queue.poll();
                if(resultMap.containsKey(top.i)) {
                    Integer step = top.step + resultMap.get(top.i);
                    if(step < minStep) {
                        minStep = step;
                    }
                    continue;
                }
                if(top.i == 0) {
                    if(top.step < minStep) {
                        minStep = top.step;
                    }
                    continue;
                }

                //branch 1
                List<Integer> factors  = factorList(top.i);
                for(Integer fac : factors) {
                    Node maxNode = new Node();
                    maxNode.i = fac;
                    maxNode.step = top.step + 1;
                    queue.offer(maxNode);
                    //System.out.println("enqueue[max]:" + maxNode.i);
                }
                //branch 2
                Node topM1 = new Node();
                topM1.i = top.i - 1;
                topM1.step = top.step + 1;
                queue.offer(topM1);
                //System.out.println("enqueue[-1]:" + topM1.i);

            }
            resultMap.put(N, minStep);
            System.out.println(minStep);
        }
    }

    public static List<Integer> factorList(int n) {
        List<Integer> factorList = new ArrayList<Integer>();
        int floor = (int)Math.ceil(Math.sqrt(n));
        int factor = n-1;
        while(factor >= floor ) {
            if(n % factor == 0)  {
                factorList.add(factor);
            }
            factor--;
        }
        return factorList;

    }



}
