package Leecode;

public class Prob_427 {
    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    public Node construct(int[][] grid)  {
        return construct(grid, 0, 0, grid.length);
    }

    public Node construct(int[][] grid, int x, int y, int height) {
        if (height == 1) {
            return  new Node(grid[x][y] == 1, true, null, null, null, null);
        }

        else {
            Node topLeft = construct(grid, x, y, height /2 );
            Node bottomLeft = construct(grid, x + height /2, y, height / 2);
            Node topRight = construct(grid, x, y + height/2, height / 2);
            Node bottomRight = construct(grid, x + height/2, y + height / 2 , height / 2);

            if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
                Node node = new Node(topLeft.val, true, null, null, null, null);
                return node;

            } else {
                Node root = new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
                return root;
            }
        }

    }

    public static void main(String[] args) {
       Node root =  new Prob_427().construct(new int[][] {    {1,1,0,0,0,0,0,0},
               {1,1,0,0,0,0,0,0},
               {1,1,0,0,0,0,1,1},
               {1,1,0,0,0,0,1,1},
               {0,0,0,0,0,0,1,1},
               {0,0,0,0,0,0,1,1},
               {1,1,1,1,1,1,0,0},
               {1,1,1,1,1,1,0,0}});
    }
//    0001
//    0000
//    1100
//    1100



}
