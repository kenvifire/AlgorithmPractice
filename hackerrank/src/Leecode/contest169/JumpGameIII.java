package Leecode.contest169;

public class JumpGameIII {
    boolean[] reached;
    boolean reachedZero = false;
    public boolean canReach(int[] arr, int start) {
        reached = new boolean[arr.length];
        reachedZero = false;
        bfs(arr, start);
        return reachedZero;
    }

    void bfs(int[] arr, int start) {
        reached[start] = true;
        if(arr[start] ==  0) {
            reachedZero = true;
            return;
        }
        int idx = start + arr[start];
        if(idx >=0 && idx < arr.length && !reached[idx]) {
            bfs(arr, idx);
        }

        idx = start - arr[start];

        if(idx >=0 && idx < arr.length && !reached[idx]) {
            bfs(arr, idx);
        }
    }

    public static void main(String[] args) {
        System.out.println(new JumpGameIII().canReach(new int[]{4,2,3,0,3,1,2}, 5));
        System.out.println(new JumpGameIII().canReach(new int[]{4,2,3,0,3,1,2}, 0));
        System.out.println(new JumpGameIII().canReach(new int[]{3,0,2,1,2}, 2));
    }
}
