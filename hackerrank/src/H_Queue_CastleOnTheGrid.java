import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by kenvi on 16/5/20.
 */
public class H_Queue_CastleOnTheGrid {
    static class Node {
        boolean isBlock ;
        int steps = 0;
        int x,y;
        boolean visited;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Node[][] matrix = new Node[N][N];
        int row = 0;
        int size = N;
        while (N-->0) {
            String input = scanner.next();
            for (int i=0; i< input.length(); i ++) {
                Node node = new Node();
                node.x = row;
                node.y = i;
                if(input.charAt(i) == '.') {
                    node.isBlock = false;
                }else {
                    node.isBlock = true;
                }
                matrix[row][i] = node;

            }

            row++;

        }

        int a,b,c,d;
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();
        int steps = 0;

        int[][] delata = new int[][]{
                {-1,0},{1,0},{0,-1},{0,1}
        };
        if(a==c && b == d) {
            System.out.print(0);
            return;
        }
        Queue<Node> nodeQueue = new ArrayDeque<Node>();
        nodeQueue.offer(matrix[a][b]);
        while(!nodeQueue.isEmpty()) {
            Node top = nodeQueue.poll();
            //System.out.println(String.format("top<==>[%s,%s,visited:%s,blocked:%s]",top.x, top.y,top.visited,top.isBlock));
            for ( int del = 0; del <=3; del++) {
                for (int inc = 1; inc < size; inc++) {
                    int nextX = top.x + delata[del][0] * inc;
                    int nextY = top.y + delata[del][1] * inc;
                    if (inMatrix(nextX, nextY, size)) {
                        Node current = matrix[nextX][nextY];
                        if(current.isBlock) break;
                        if (!current.visited ) {
                            current.steps = top.steps + 1;
                            //System.out.println(String.format("==>(%s,%s,visited:%s,blocked:%s)", nextX, nextY, current.visited,current.isBlock));
                            current.visited =true;
                            if (current.x == c && current.y == d) {
                                steps = current.steps;
                                break;
                            }
                            nodeQueue.offer(current);
                        }

                    }else{
                        break;
                    }
                }
            }



        }

        System.out.print(steps);
    }

    private static boolean inMatrix(int x, int y, int N) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }



}
