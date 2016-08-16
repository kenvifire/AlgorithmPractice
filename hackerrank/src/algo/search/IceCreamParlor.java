package algo.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by hannahzhang on 16/8/15.
 */
public class IceCreamParlor {
    static class Node implements Comparable<Node>{
        int index;
        int data;

        @Override
        public int compareTo(Node o) {
            return this.data - o.data;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T --> 0) {
            int M, N;
            M = scanner.nextInt();
            N = scanner.nextInt();
            Node[] c = new Node[N];
            for (int i = 0; i < N; i++) {
                c[i] = new Node();
                c[i].index = i;
                c[i].data = scanner.nextInt();
            }

            Arrays.sort(c);

            for (int i = 0; i < c.length - 1; i++) {
                int left = M - c[i].data;
                Node leftNode = new Node();
                leftNode.data = left;

                int leftIndex =  Arrays.binarySearch(c,i+1,c.length, leftNode);
                if(leftIndex > 0) {
                    int right = c[leftIndex].index;
                    int iIndex = c[i].index;
                    System.out.println((Math.min(iIndex,right)+1) + " " + (Math.max(iIndex,right)+1));
                    break;
                }
            }

        }
    }
}
