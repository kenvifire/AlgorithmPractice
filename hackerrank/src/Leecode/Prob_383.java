package Leecode;

import utils.MapUtils;
import utils.StringUtils;

import java.util.Map;

public class Prob_383 {
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> ransomNoteMap = StringUtils.strToCntMap(ransomNote);
        Map<Character, Integer> magzineMap = StringUtils.strToCntMap(magazine);

        return MapUtils.countMapContains(magzineMap, ransomNoteMap);

    }

    public static void main(String[] args) {
        System.out.println(new Prob_383().canConstruct("a", "b"));
        System.out.println(new Prob_383().canConstruct("aa", "ab"));
        System.out.println(new Prob_383().canConstruct("aa", "aab"));
        System.out.println(new Prob_383().canConstruct("", ""));
        System.out.println(new Prob_383().canConstruct("", "a"));
        System.out.println(new Prob_383().canConstruct("b", ""));
    }
}
