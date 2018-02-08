package contest.w36;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kenvi on 2018/2/7.
 */
public class WaysToGiveACheck {

    static int[][] knightMove = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2,1}, {-2,-1}};

    static int waysToGiveACheck(char[][] board) {
        // Complete this function
        Point validPawn = null;

        List<Point> pointList = new ArrayList<>();
        for (int i = 0 ; i < 8 ; i++) {
            if (board[1][i] == 'P' && board[0][i-1] == '#') {
                validPawn = new Point(1, i);
            }
        }
        Point king = null;


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board[i][j] != '#') {
                    if(i == 1 && j == validPawn.y) {
                        pointList.add(new Point(0,j));
                    } else {
                        pointList.add(new Point(i,j));
                    }

                    if(board[i][j] == 'k') {
                       king = new Point(i,j);
                    }
                }
            }
        }

        int count = 0;
        // pown promotion check
        Point promotePaw = new Point(validPawn.x - 1, validPawn.y);

        char[] promoList  = {'Q', 'N', 'B', 'K'};
        for (char pro : promoList) {
            board[validPawn.x][validPawn.y] = '#';
            board[promotePaw.x][promotePaw.y] = pro;
            boolean canCheck = false;
            for (Point point : pointList) {
                char piece = board[point.x][point.y];
                switch (piece) {
                    case 'K':
                        canCheck = checkKing(king, point);
                        break;
                    case 'Q':
                        canCheck = checkQueen(pointList, king, point);
                        break;
                    case 'N':
                        canCheck = checkKnight(king, point);
                        break;
                    case 'B':
                        canCheck = checkBishop(pointList, king, point);
                        break;
                    case 'R':
                        canCheck = checkRook(pointList, king, point);
                        break;
                    case 'P':
                        canCheck = checkPawn(king, point);
                        break;
                }

                if (canCheck) {
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }


    //8 directions, no obstacle
    static boolean checkQueen(List<Point> pointList, Point king, Point queue) {
        // check if check
        boolean check = isDiagonalCheck(king, queue) || isStraightLineCheck(king, queue);
        // check obstacle
        for (Point p : pointList) {
            if(!p.equals(king) && !p.equals(queue)) {
                if (isInline(king, queue, p)) {
                    return false;
                }
            }
        }

        return check;
    }

    static boolean checkKing(Point king, Point king2) {
        return  (king.x == king2.x     && king.y == king2.y + 1)||
                (king.x == king2.x     && king.y == king2.y - 1) ||
                (king.x == king2.x - 1 && king.y == king2.y)     ||
                (king.x == king2.x + 1 && king.y == king2.y)     ||
                (king.x == king2.x + 1 && king.y == king2.y + 1) ||
                (king.x == king2.x + 1 && king.y == king2.y - 1) ||
                (king.x == king2.x - 1 && king.y == king2.y + 1) ||
                (king.x == king2.x - 1 && king.y == king2.y - 1);
    }

    //4 directions, no obstacle
    static boolean checkRook(List<Point> pointList, Point king, Point rook) {
        // check if check
        boolean check = isStraightLineCheck(king, rook);
        // check obstacle
        for (Point p : pointList) {
            if(!p.equals(king) && !p.equals(rook)) {
                if (isInline(king, rook, p)) {
                    return false;
                }
            }
        }

        return check;

    }

    //4 diagonal directions, no obstacle
    static boolean checkBishop(List<Point> pointList, Point king, Point bishop) {
        // check if check
        boolean check = isDiagonalCheck(king, bishop);
        // check obstacle
        for (Point p : pointList) {
            if(!p.equals(king) && !p.equals(bishop)) {
                if (isInline(king, bishop, p)) {
                    return false;
                }
            }
        }
        return check;
    }

    //8 positions, ignore obstacle
    static boolean checkKnight(Point king, Point knight) {
        for (int[] move : knightMove) {
            if(king.x == (knight.x + move[0]) && king.y == (knight.y + move[1])) {
               return true;
            }
        }
        return false;

    }

    static boolean checkPawn(Point king, Point pawn) {
        return (king.x == pawn.x + 1 && king.y == pawn.y - 1) || (king.x == pawn.x + 1 && king.y == pawn.y + 1);
    }

    static boolean isInline(Point A, Point B, Point C) {
        return Math.abs(Math.sqrt((A.x - B.x)*(A.x - B.x) + (A.y - B.y)*(A.y - B.y)) -
                ((Math.sqrt((A.x - C.x)*(A.x - C.x) + (A.y - C.y)*(A.y - C.y)) +
                        Math.sqrt((B.x - C.x)*(B.x - C.x) + (B.y - C.y)*(B.y - C.y))))) <= 1e-6;

    }

    static boolean isDiagonalCheck(Point king, Point attacker) {
        return Math.abs(king.x - attacker.x) == Math.abs(king.y - attacker.y);
    }

    static boolean isStraightLineCheck(Point king, Point attacker) {
        return king.x == attacker.x || king.y == attacker.y;
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x * 8 + y;
        }

        @Override
        public boolean equals(Object obj) {
            Point o = (Point)obj;
            return this.x == o.x && this.y == o.y;
        }
    }




    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for(int a0 = 0; a0 < t; a0++){
            char[][] board = new char[8][8];
            for(int board_i = 0; board_i < 8; board_i++){
                board[board_i] = in.nextLine().toCharArray();
            }
            int result = waysToGiveACheck(board);
            System.out.println(result);
        }
        in.close();
    }
}
