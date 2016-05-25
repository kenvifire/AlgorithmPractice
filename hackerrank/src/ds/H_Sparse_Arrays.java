import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by kenvi on 16/5/5.
 */
public class H_Sparse_Arrays {
    public static void main(String[] args) {
        int N;
        int Q;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        HashMap<String,Integer> stringMap = new HashMap<String, Integer>(N);

        String line;
        while(N-->0) {
            line = scanner.next();
            Integer value = stringMap.get(line);
            if (value == null) {
                stringMap.put(line, 1);
            }else {
                stringMap.put(line, value+1);
            }
        }

        Q = scanner.nextInt();
        while (Q --> 0) {
            line = scanner.next();
            Integer value = stringMap.get(line);
            System.out.println(value == null ? "0" : value);
        }
    }
}
