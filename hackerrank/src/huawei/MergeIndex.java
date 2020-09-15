package huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MergeIndex {
    static class Pair {
        int index, value;
        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
        void addValue(int value) {
            this.value += value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Map<Integer, Pair> pairMap = new TreeMap<>(Integer::compareTo);
            while (n --> 0) {
                int index = scanner.nextInt();
                int value = scanner.nextInt();
                Pair pair = pairMap.getOrDefault(index, new Pair(index, 0));
                pair.addValue(value);
                pairMap.put(index, pair);
            }
            for (Pair pair : pairMap.values()) {
                System.out.printf("%d %d\n", pair.index, pair.value);
            }

        }
    }
}
