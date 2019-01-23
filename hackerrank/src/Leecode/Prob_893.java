package Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob_893 {
    static class FinterPrint implements Comparable<FinterPrint> {
        String str;
        public FinterPrint(String str)  {
            this.str = str;
            for (int i = 0; i < str.length(); i++) {
                increaseValue(str.charAt(i) - 'a', i % 2 == 0);
            }
        }

        int[] fingerPrint = new int[52];

        void increaseValue(int index, boolean isEven) {
            int i = 2 * index + (isEven ? 0 : 1);
            fingerPrint[i]  = fingerPrint[i] + 1;
        }


        @Override
        public int compareTo(FinterPrint o) {
            for (int i = 0; i < fingerPrint.length; i++) {
                if(o.fingerPrint[i] != this.fingerPrint[i]) return this.fingerPrint[i] - o.fingerPrint[i];
            }
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            FinterPrint other = (FinterPrint) obj;

            for (int i = 0; i < fingerPrint.length; i++) {
                if(other.fingerPrint[i] != this.fingerPrint[i]) return false;
            }
            return true;

        }
    }
    public int numSpecialEquivGroups(String[] A) {
        List<FinterPrint> fingerPrintList = new ArrayList<>();

        for (String str : A) {
            FinterPrint finterPrint = new FinterPrint(str);
            fingerPrintList.add(finterPrint);
        }

        Collections.sort(fingerPrintList);



        FinterPrint fp = fingerPrintList.get(0);
        int count = 1;

        for (int i = 1; i < fingerPrintList.size(); i++) {
           if(!fp.equals(fingerPrintList.get(i))) {
               fp = fingerPrintList.get(i);
               count ++;

           }
        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(new Prob_893().numSpecialEquivGroups(new String[] {"ea","we","vd","qx","zd","dm","vc","uh","ps","pd","sy","bq","lm","hb","pi","ca","he","hq","wl","bb","rs","db","ca","ry","cd","rl","ee","us","br","dm","cf","vm","me","jo","lh","pc","mt","tn","br","hb","pi","wl","dm","qx","pi","mt","pi","pi","db","us"}));
    }

}
