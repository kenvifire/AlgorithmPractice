package amazon;

/**
 * Created by kenvi on 16/8/14.
 */
public class AmazonLocakerLocations {
    public static void main(String[] args) {
        int cityLength = 5;
        int cityWidth = 7;
        int[] lockerXCoordinates = new int[]{2,4};
        int[] lockerYCoordinates = new int[]{3,7};

        int[][] matrix = getLockerDistanceGrid(cityLength, cityWidth, lockerXCoordinates, lockerYCoordinates);

        for (int x = 0; x < cityLength; x++) {
            for (int y = 0; y < cityWidth; y++) {
                System.out.print(matrix[x][y]);
            }
            System.out.println();
        }


    }

    static int[][] getLockerDistanceGrid(int cityLength, int cityWidth,
                                         int[] lockerXCoordinates, int[] lockerYCoordinates) {

        int[][] distanceMatrix = new int[cityLength][cityWidth];

        for (int x = 1; x <= cityLength; x++) {
            for (int y = 1; y <= cityWidth; y++) {
                distanceMatrix[x - 1][y - 1] = shortestDistance(x, y, lockerXCoordinates, lockerYCoordinates);
            }
        }
        return distanceMatrix;

    }

    static int shortestDistance(int x, int y, int[] lockerXCoordinates, int[] lockerYCoordinates) {
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < lockerXCoordinates.length; i++) {
            int distance = Math.abs(lockerXCoordinates[i] - x) + Math.abs(lockerYCoordinates[i] - y);


            if (distance == 0) return distance;

            if (distance < minDistance)
                minDistance = distance;
        }
        return minDistance;
    }


}
