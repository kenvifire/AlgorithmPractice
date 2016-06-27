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
        Map<Character,Integer>  steadyMap = new HashMap<>();
        geneMap.put('A', 0);
        steadyMap.put('A', 0);
        geneMap.put('C', 0);
        steadyMap.put('C', 0);
        geneMap.put('G', 0);
        steadyMap.put('G', 0);
        geneMap.put('T', 0);
        steadyMap.put('T', 0);

        int max = line.length() / 4;

        for (int k = 0; k < line.length(); k++) {
            Integer value = geneMap.get(line.charAt(k));
            geneMap.put(line.charAt(k), value+1);
        }
        int count = 0;
        if(geneMap.get('A') > max) { steadyMap.put('A', geneMap.get('A') - max); count++;}
        if(geneMap.get('C') > max) { steadyMap.put('C', geneMap.get('C') - max); count++;}
        if(geneMap.get('G') > max) { steadyMap.put('G', geneMap.get('G') - max); count++;}
        if(geneMap.get('T') > max) { steadyMap.put('T', geneMap.get('T') - max); count++; }

        if(count == 0) {
            System.out.println(0);
            return;
        }

        while (i < j && (isNotSteady(geneMap,steadyMap,line.charAt(i)) ||
                isNotSteady(geneMap, steadyMap, line.charAt(j)))) {

            if(!isNotSteady(geneMap, steadyMap, line.charAt(i))) {
                i++;
            }

            if(!isNotSteady(geneMap, steadyMap, line.charAt(j))) {
                j--;
            }
        }

        System.out.println(j - i);

    }

    public static boolean isNotSteady(Map<Character,Integer> geneMap,
                                      Map<Character,Integer> steadyMap, char ch) {
        return (geneMap.get(ch) > steadyMap.get(ch));

    }
}
