/**
 * Created by hannahzhang on 16/5/8.
 */
public class H_A_01 {
    public static void main(String[] args) {

        int[] xLocker = new int[2];
        xLocker[0] = 1;
        //xLocker[1] = 4;

        int[] yLocker = new int[2];
        yLocker[0] = 1;
        //yLocker[1] = 7;

        int length =3;
        int width = 5;
        int[][] result = getLockerDistanceGrid(length, width, xLocker, yLocker);

        for (int i=0; i< length; i ++) {
            for (int j =0; j< width; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }



    }
    static int[][] getLockerDistanceGrid(int cityLength, int cityWidth, int[] lockerXCoordinates, int[] lockerYCoordinates) {
        int[][] result = new int[cityWidth][cityLength];

        for (int w = 1; w <= cityWidth; w++) {
            for (int l = 1; l <= cityLength; l++) {
                int min = Integer.MAX_VALUE;

                // for each point, find min distance
                for (int x = 0 ; x < lockerXCoordinates.length; x++) {
                    int dis = Math.abs(w -lockerYCoordinates[x]) + Math.abs(l -lockerXCoordinates[x]);


                    if(dis < min ) min = dis;
                }
                result[w -1][l -1] = min;
            }
        }
        // result need to reverse to pass the online judge.
        int[][] finalResult = new int[cityLength][cityWidth];
        for (int l=0; l < cityLength; l++)
            for (int w = 0; w < cityWidth; w++) {
                finalResult[l][w] = result[w][l];
            }

        return finalResult;
    }

}
