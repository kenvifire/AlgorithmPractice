package algo;

/**
 * Created by hannahzhang on 16/6/23.
 */
public class H_Implementation_MatrixRotationAlgo {

    public static void main(String[] args) {

    }

    public static void rotation(int[][] matrix, int x, int y, int w, int h, int r) {
        r = r % (2 * w + 2 * h);

        while (r -- > 0) {

        }
    }

    public static int[] getIndex(int x, int y, int w, int h, int i) {
        int[] index = new int[2];
        i  = i % (2 * w + 2 * h);
        if(i <= w) {
            index[0] = x;
            index[1] = i;
        }else if(i > w && i <= w+h) {
            index[0] = x + (i- w - h);
            index[1] = y;
        }else if(i > w+h && i <= 2*w +h ) {
            index[0] = x + h;
            index[1] = y + (2 * w +h - i );
        }else {
            index[0]= x + (2*w + 2*h - i);
            index[1] = y;
        }
        return index;

    }
}
