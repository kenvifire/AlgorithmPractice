package Leecode;

public class Vector2D {
    int[][] store;
    int x = 0;
    int y = 0;
    public Vector2D(int[][] vec) {
        this.store = vec;
    }

    public int next() {
        ensureNext();
        int val = store[x][y];
        y++;
        return val;
    }

    public boolean hasNext() {
        ensureNext();
        return x < store.length;

    }
    public void ensureNext() {
        while (x < store.length && y >= store[x].length) {
            x++;
            y = 0;
        }
    }

    public static void main(String[] args) {
        int[][] vec = new int[][]{{1,2},{3}, {4}};
        Vector2D vector = new Vector2D(vec);
        while (vector.hasNext()) {
            System.out.println(vector.next());
        }
    }
}
