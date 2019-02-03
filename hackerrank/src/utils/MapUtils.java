package utils;

import java.util.Map;
import java.util.function.BinaryOperator;

public class MapUtils {
    public static<T>  boolean  countMapContains(Map<T, Integer> map1, java.util.Map<T, Integer> map2){
        if(map1.isEmpty() && map2.isEmpty()) return true;
        return map2.entrySet().stream().map(e -> map1.getOrDefault(e.getKey(), Integer.valueOf(0)) >= e.getValue()).reduce(new BinaryOperator<Boolean>() {
            @Override
            public Boolean apply(Boolean aBoolean, Boolean aBoolean2) {
                return aBoolean && aBoolean2;
            }
        }).get();

    }
}
