package algo.hackrank.algo.uncategoried;

import java.util.*;

/**
 * Created by kenvi on 16/6/15.
 */
public class H_Implementation_ManasaAndStones {
    public static void main(String[] args) {
        int T, n, a, b;
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        while (T --> 0) {
            n = scanner.nextInt();
            a = scanner.nextInt();
            b = scanner.nextInt();
            Queue<Integer> set = new ArrayDeque<>();
            Set<Integer> tmpSet = new HashSet<>();
            set.add(0);
            if( n == 1) {
                System.out.println(0);
                continue;
            }
            for (int i = 1; i < n; i++) {
                tmpSet.clear();
                while (!set.isEmpty()) {
                    int top = set.poll();
                    tmpSet.add(top + a);
                    tmpSet.add(top + b);
                }
                set.addAll(tmpSet);
            }
            List<Integer> list = new ArrayList<>(tmpSet);
            Collections.sort(list);

            for (Integer l : list) {
                System.out.printf(l + " ");
            }
            System.out.println();

        }
    }
}
