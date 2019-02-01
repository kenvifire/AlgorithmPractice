package Leecode;

import utils.MapUtils;
import utils.StringUtils;

import java.util.Arrays;
import java.util.Map;

public class Prob_748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {

        StringBuilder sb =new StringBuilder();

        for (int i = 0; i < licensePlate.length(); i++) {
            if(Character.isAlphabetic(licensePlate.charAt(i))) {
                sb.append(licensePlate.charAt(i));
            }
        }
        Map<Character, Integer> originCnt = StringUtils.strToCntMap(sb.toString().toLowerCase());


        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < words.length; i++) {
            Map<Character, Integer> strCntMap = StringUtils.strToCntMap(words[i]);
            if(MapUtils.countMapContains(strCntMap, originCnt)) {
                if(words[i].length() < min) {
                    min = words[i].length();
                    index = i;
                }
            }
        }

        return words[index];

    }

    public static void main(String[] args) {
//        System.out.println(new Prob_748().shortestCompletingWord("1s3PSt", new String[] {"step", "steps", "stripe", "stepple"}));
        System.out.println(new Prob_748().shortestCompletingWord("1s3 456", new String[] {"looks","pest","stew","show"}));
    }
}
