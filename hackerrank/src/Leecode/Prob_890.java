package Leecode;

import utils.AssertUtils;
import utils.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Prob_890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if(matches(word, pattern)) result.add(word);
        }
        return result;

    }

    private boolean matches(String word, String pattern){
        if(word.length() != pattern.length())  return false;
        Map<Character, Character> replaceMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char wordCh = word.charAt(i);
            char pattenCh = pattern.charAt(i);

            if(replaceMap.containsKey(wordCh)) {
                char replaceCh = replaceMap.get(wordCh);
                if(replaceCh != pattenCh) return false;
            } else {
                replaceMap.put(wordCh, pattenCh);
            }
        }
        Set<Character> valueSet = new HashSet<>();
        valueSet.addAll(replaceMap.values());
        return valueSet.size() == replaceMap.keySet().size();
    }

    public static void main(String[] args) {
        Prob_890 prob = new Prob_890();
        PrintUtils.printStringList(prob.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
    }
}
