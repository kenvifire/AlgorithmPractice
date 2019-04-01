package Leecode;

public class Prob_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int R = matrix.length;
        int C = matrix[0].length;

        int left = 0, right = R * C - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int x = mid / C;
            int y = mid % C;

            if(matrix[x][y] < target) {
                left = mid + 1;

            } else if(matrix[x][y] > target) {
                right = mid - 1;
            } else {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Prob_74 prob = new Prob_74();
        prob.searchMatrix(new int[][] {{1,3,5,7}, {10,11,16,20},{23,30,34,50}}, 3);
    }



}
