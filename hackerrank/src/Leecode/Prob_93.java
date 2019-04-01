package Leecode;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class Prob_93 {
    List<String> result;
    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        restore(s, 0, temp, 0);
        return result;
    }

    private void restore(String s, int pos, List<String> stringList, int seg) {
        if (pos < s.length() && seg == 4) return;
        if (pos >= s.length()) return;

        if (seg == 3) {
            if (pos == s.length() - 1) {
                for (String str : stringList) {
                    result.add(str + "." + s.substring(pos));
                }
            } else if(pos == s.length() - 2) {
                if(validDouble(s, pos)) {
                    for (String str : stringList) {
                        result.add(str + "." +s.substring(pos));
                    }
                }
            }
            else if (pos == s.length() - 3) {
                if (validTriple(s, pos)) {
                    for (String str : stringList) {
                        result.add(str +  "." + s.substring(pos));
                    }
                }
            } else {
                return;
            }
        } else {
            //single
            if(pos < s.length() - 1) {
                List<String> temp = new ArrayList<>();
                if(stringList.isEmpty()) {
                    temp.add(s.substring(pos, pos + 1));
                } else {
                    for (String str : stringList) {
                        temp.add(str + "." + s.charAt(pos));
                    }
                }
                restore(s, pos + 1, temp, seg + 1);
            }

            //double
            if(pos < s.length() - 2) {
                List<String> doubleList = new ArrayList<>();
                if (validDouble(s, pos)) {
                    if(stringList.isEmpty()) {
                        doubleList.add(s.substring(pos, pos + 2));
                    } else {
                        for (String str : stringList) {
                            doubleList.add(str + "." + s.substring(pos, pos + 2));
                        }
                    }
                    restore(s, pos + 2, doubleList, seg + 1);
                }
            }

            //triple
            if(pos < s.length() - 3) {
                if (validTriple(s, pos)) {

                    List<String> tripleList = new ArrayList<>();
                    if(stringList.isEmpty()) {
                        tripleList.add(s.substring(pos, pos + 3));
                    } else {
                        for (String str : stringList) {
                            tripleList.add(str + "." + s.substring(pos, pos + 3));
                        }
                    }
                    restore(s, pos + 3, tripleList, seg + 1);
                }
            }
        }
    }

    private boolean validDouble(String s, int pos) {
        return Integer.valueOf(s.substring(pos, pos + 2)).toString().length() == 2;
    }

    private boolean validTriple(String s, int pos) {
        int val = Integer.valueOf(s.substring(pos, pos + 3));
        return val <= 255 && String.valueOf(val).length() == 3;
    }

    public static void main(String[] args) {
        Prob_93 prob = new Prob_93();
        List<String> result = prob.restoreIpAddresses("0000");
//        PrintUtils.printStringList(result);
//        result = prob.restoreIpAddresses("25525511135");
//        PrintUtils.printStringList(result);
//        result = prob.restoreIpAddresses("255");
//        PrintUtils.printStringList(result);
        result = prob.restoreIpAddresses("172162541");
        PrintUtils.printStringList(result);
    }



}
