package algo.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kenvi on 16/8/17.
 */
public class BeautifulPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer,Integer> mA = new HashMap<>();
        Map<Integer,Integer> mB = new HashMap<>();
        int key;
        for (int i = 0; i < n; i++) {
            key = scanner.nextInt();
            addOrPutDefault(mA, key, 1);
        }
        for (int i = 0; i < n; i++) {
             key = scanner.nextInt();
            addOrPutDefault(mB, key, 1);
        }
        int total = 0;
        for (Map.Entry<Integer,Integer> entry : mA.entrySet()) {
            Integer va = entry.getValue();
            Integer vb = mB.get(entry.getKey());

            if(vb != null)  {
                total += Math.min(va, vb);
            }
        }

        if(total == n) System.out.println(total-1);
        else System.out.println(total+1);

    }

    public static void addOrPutDefault(Map<Integer,Integer> map, int key, int defaultValue) {
        Integer value = map.get(key);
        if(value == null) {
            map.put(key, defaultValue);
        }else {
            map.put(key, value + 1);
        }
    }
}
