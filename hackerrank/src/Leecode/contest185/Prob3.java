package Leecode.contest185;

import java.util.HashMap;
import java.util.Map;

public class Prob3 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        Map<Integer, Integer> frogs = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char ch = croakOfFrogs.charAt(i);

            int step = -1;

            switch (ch) {
                case 'c': step = 0; break;
                case 'r': step = 1; break;
                case 'o': step = 2; break;
                case 'a': step = 3; break;
                case 'k': step = 4; break;
            }

            int val = frogs.getOrDefault(step - 1, 0);

            if(val == 0) {
                if(step == 0) {
                    //new frog
                    cnt ++;
                    frogs.put(step , frogs.getOrDefault(step, 0) + 1);
                } else {
                    return -1;
                }
            } else {
                frogs.put(step - 1, val - 1) ;
                int next = step != 4 ? step : -1;
                frogs.put(next, frogs.getOrDefault(next, 0) + 1);
            }


        }

        //final check
        for(Map.Entry<Integer, Integer> frog : frogs.entrySet()) {
            if (frog.getKey() >= 0 && frog.getValue() > 0) return  -1;
        }
        return cnt;

    }


    public static void main(String[] args) {
        Prob3 prob3 = new Prob3();
//        System.out.println(prob3.minNumberOfFrogs("croak"));
//        System.out.println(prob3.minNumberOfFrogs("croakcroak"));
//        System.out.println(prob3.minNumberOfFrogs("crcoakroak"));
//        System.out.println(prob3.minNumberOfFrogs("croakcrook"));
//        System.out.println(prob3.minNumberOfFrogs("croakcroa"));
//        System.out.println(prob3.minNumberOfFrogs(""));
//        System.out.println(prob3.minNumberOfFrogs("croakc"));
//        System.out.println(prob3.minNumberOfFrogs("croakcr"));
//        System.out.println(prob3.minNumberOfFrogs("croakcro"));
//        System.out.println(prob3.minNumberOfFrogs("croakcroa"));
//        System.out.println(prob3.minNumberOfFrogs("croakcroak"));
        System.out.println(prob3.minNumberOfFrogs("ccrrooaakk"));
        System.out.println(prob3.minNumberOfFrogs("ccrrooaakkcroakcccrrroooaaakkkcroak"));



    }
}
