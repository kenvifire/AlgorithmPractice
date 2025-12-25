package Leecode;

import java.util.*;

public class Prob3076 {
    public String[] shortestSubstrings(String[] arr) {
        String [] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = "";
        }

        Map<String, Set<Integer>> subSetMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for(int m = 0; m < arr[i].length(); m++){
                for(int n = m+1; n <= arr[i].length(); n++){
                    String sub = arr[i].substring(m, n);
                    Set<Integer> set = subSetMap.getOrDefault(sub, new HashSet<>());
                    set.add(i);
                    subSetMap.put(sub, set);
                }
            }
        }
        for(Map.Entry<String, Set<Integer>> entry : subSetMap.entrySet()) {
            if(entry.getValue().size() == 1){
                String sub = entry.getKey();
                Integer index = entry.getValue().stream().findAny().get();
                if(result[index].isEmpty()){
                    result[index] = sub;
                } else if(sub.length() < result[index].length()){
                    result[index] = sub;
                } else if(sub.length() == result[index].length()){
                    result[index] = result[index].compareTo(sub) < 0 ? result[index] : sub;
                }
            }
        }

        return result;
    }

    static void main() {
        Prob3076 p = new Prob3076();
//        System.out.println(Arrays.toString(p.shortestSubstrings(new String[]{"cab","ad","bad","c"})));
//        System.out.println(Arrays.toString(p.shortestSubstrings(new String[]{"abc","bcd","abcd"})));
//        System.out.println(Arrays.toString(p.shortestSubstrings(new String[]{"abc","","abcd"})));
        System.out.println(Arrays.toString(p.shortestSubstrings(new String[]{"gfnt","xn","mdz","yfmr","fi","wwncn","hkdy"})));
    }
}

