package algo.hackrank.algo.uncategoried;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/29.
 */
public class H_String_ReverseShuffleMerge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<Character,Integer> originCntMap = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            Integer value = originCntMap.get(ch);
            if(value == null) {
                originCntMap.put(ch, 1);
            }else {
                originCntMap.put(ch, value+1);
            }

        }
        Map<Character,Integer> destCntMap = new HashMap<>();
        Map<Character,Integer> currentMap = new HashMap<>();
        char[] chars = new char[originCntMap.size()];
        int index = 0;
        for (Map.Entry<Character,Integer> entry : originCntMap.entrySet()) {
            destCntMap.put(entry.getKey(), entry.getValue()/2);
            chars[index] = entry.getKey();
            index++;
            currentMap.put(entry.getKey(), 0);
        }
        Arrays.sort(chars);

        StringBuilder result = new StringBuilder();
        for (int i=line.length() - 1; i >=0;i--) {
            char current = line.charAt(i);
            Integer value;
            //skip if current character is not required
            if(currentMap.get(current) >= destCntMap.get(current)) {
                //skip
            }else if(originCntMap.get(current) - 1 < destCntMap.get(current) - currentMap.get(current)) {
                //if not avaliable left, add it
                result.append(current);
                value = currentMap.get(current);
                currentMap.put(current, value + 1);
            }else {
                //chose smallest
                char smallest = getSmallest(destCntMap, currentMap, chars);
                if(current == smallest) {
                    result.append(current);
                    value = currentMap.get(current);
                    currentMap.put(current, value + 1);
                }
            }
            value = originCntMap.get(current);
            originCntMap.put(current, value-1);


        }
        System.out.println(result.toString());
    }

    public static Character getSmallest(Map<Character,Integer> destMap,
                            Map<Character,Integer> currentMap, char[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            char ch =  arrays[i];
            if(currentMap.get(ch) < destMap.get(ch)) {
                return ch;
            }
        }
        return null;
    }
}
