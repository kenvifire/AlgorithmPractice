package Leecode;

import java.util.ArrayList;
import java.util.List;

public class Prob_504 {
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        List<Character> characterList = new ArrayList<>();
        int base = 7;
        boolean negative = num < 0 ? true : false;
        if(negative) num = -num;

        while (num > 0) {
            char ch = (char)('0' + (num % base));
            characterList.add(ch);
            num /= base;
        }

        StringBuilder sb = new StringBuilder();
        if(negative) sb.append('-');

        for (int i = characterList.size() - 1; i >=0; i--) {
            sb.append(characterList.get(i));
        }
        return sb.toString();
    }
}
