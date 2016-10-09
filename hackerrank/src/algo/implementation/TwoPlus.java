package algo.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kenvi on 16/10/9.
 */
public class TwoPlus {

    static class Plus implements Comparable<Plus>{

        public Plus(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
        private int x,y;
        private int length;

        @Override
        public int compareTo(Plus o) {
            return o.length - this.length;
        }

        public int getArea() {
            return 4 * (length - 1) + 1;
        }

        public boolean containsPoint(int px, int py) {
            if(px == x) return  (py >= y-(length-1)) && (py <= y+(length-1));
            if(py == y) return  (px >= x-(length-1) && (px <= x+(length-1)));
            return false;
        }

        public boolean isOverlap(Plus p) {
            for (int px = x-(length-1); px <= x+(length-1); px++) {
                if(p.containsPoint(px, y)) {
                    return true;
                }
            }

            for (int py = y-(length-1); py <= y+(length-1); py++) {
                if(p.containsPoint(x,py)) {
                    return true;
                }
            }

            return false;
        }

        public String toString() {
            return "{" + this.x +"," + this.y+":" + this.length+ " " + getArea()  + "}";
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] matrix = new int[N][M];
        String line;
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
           line = scanner.nextLine();
            for (int j = 0; j < M; j++) {
               matrix[i][j] = line.charAt(j) == 'G' ? 1 : 0;
            }
        }

        solve(matrix);






    }

    public static void solve(int[][] matrix) {
        List<Plus> plusList = new ArrayList<>();

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                List<Plus> p = getMaxPlus(matrix, x, y);
                if(p != null) {
                   plusList.addAll(p);
                }
            }
        }

        int max = -1;

        for (int i = 0; i < plusList.size()-1; i++) {
            for (int j = i+1; j < plusList.size(); j++) {
                Plus p1 = plusList.get(i);
                Plus p2 = plusList.get(j);
                if(!p1.isOverlap(p2)) {
                    int product = p1.getArea() * p2.getArea();
                    if(product > max) {
                        max = product;
//                        System.out.println("new max\n" + p1.toString() + p2.toString());

                    }
                }
            }
        }
        System.out.println(max);


    }

    public static List<Plus> getMaxPlus(int[][] matrix, int x, int y) {
        if(matrix[x][y] == 0) return null;
        List<Plus> pList = new ArrayList<>();

        int length = 0;
        while (isValid(matrix,x+length, y)
                && isValid(matrix, x-length, y)
                && isValid(matrix, x, y+length)
                && isValid(matrix, x, y-length)
                ){
            pList.add(new Plus(x,y,length+1));
            length++;
        }

        return pList;
    }

    public static boolean isValid(int[][] matrix, int x, int y) {
        return (x>=0 && x<matrix.length) && (y>=0 && y < matrix[0].length) && matrix[x][y] == 1;
    }



}
