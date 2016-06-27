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

        for (int k = 0; k < line.length(); k++) {
            Integer value = geneMap.get(line.charAt(k));
            geneMap.put(line.charAt(k), value+1);
        }
        int max = line.length() / 4;

        if(geneMap.get('A') == max && geneMap.get('C') == max
                && geneMap.get('G') == max && geneMap.get('T') == max) {
            System.out.println(0);
            return;
        }
        int right = 0, left = 0, dist = 0;

        //find right bound
        while (right < line.length() && !isNotSteady(geneMap, max) ) {
                char ch = line.charAt(right);
                Integer value = geneMap.get(ch);
                geneMap.put(ch, value-1);
                right++;
        }
        dist = right;

        while (left < right && right < line.length()) {
           if (!isNotSteady(geneMap,max)) {
               Integer value = geneMap.get(line.charAt(right));
               geneMap.put(line.charAt(right), value-1);
               right++;
           }else {
               if(right - left < dist) dist = right -left;

               Integer value = geneMap.get(line.charAt(left));
               geneMap.put(line.charAt(left), value + 1);
               left++;
           }
        }
        System.out.println(dist);


    }

    public static boolean isNotSteady(
                                      Map<Character,Integer> steadyMap, int max) {
        return steadyMap.get('A') <= max && steadyMap.get('C') <= max
                && steadyMap.get('G') <= max && steadyMap.get('T') <=max;

    }
}
