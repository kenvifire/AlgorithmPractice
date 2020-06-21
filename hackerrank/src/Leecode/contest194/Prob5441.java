package Leecode.contest194;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prob5441 {
    public String[] getFolderNames(String[] names) {
        Set<String> nameSet = new HashSet<>();
        String[] result = new String[names.length];
        Map<String, Integer> prefix = new HashMap<>();

        for(int i = 0; i < names.length; i++) {
            String name = names[i];
            if(!nameSet.contains(name)) {
                result[i] = name;
            } else {
                Integer value = prefix.getOrDefault(name, 0);
                while(nameSet.contains(name + "(" + (value+1) + ")")) {
                    value ++;
                }
                prefix.put(name, value + 1);
                result[i] = name + "(" + (value + 1) +")";
            }
            nameSet.add(result[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Prob5441 prob5441 = new Prob5441();
        prob5441.getFolderNames(new String[] {"gta","gta(1)","gta","avalon"});
    }
}
