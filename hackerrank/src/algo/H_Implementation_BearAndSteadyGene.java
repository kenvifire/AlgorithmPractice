package algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/25.
 */
public class H_Implementation_BearAndSteadyGene {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();

        int i = 0, j = line.length() - 1;
        Map<Character,Integer> geneMap = new HashMap<>();
        geneMap.put('A', 0);
        geneMap.put('C', 0);
        geneMap.put('G', 0);
        geneMap.put('T', 0);

        int max = line.length() / 4;

        while (i < line.length() -1 && isSteady(geneMap, max, line.charAt(i))) {
            char ch = line.charAt(i);
            Integer v = geneMap.get(line.charAt(i));
            geneMap.put(ch, v+1);

            i++;
        }

        while (i < j && isSteady(geneMap, max, line.charAt(j))) {
            char ch = line.charAt(j);
            Integer v = geneMap.get(ch);
            geneMap.put(ch, v+1);

            j--;
        }

//        System.out.println(String.format("{%s,%s}",i,j));

        if(i < j) {
            System.out.println(j-i+1);
        }else{
            System.out.println(0);
        }
    }

    public static boolean isSteady(Map<Character,Integer> map, int max, char ch) {
        return map.get(ch) < max;

    }
}
