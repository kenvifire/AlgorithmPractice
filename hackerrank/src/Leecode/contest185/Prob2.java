package Leecode.contest185;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Prob2 {

    static class Table {
        int number;
        Map<String, Integer> items = new HashMap<>();

        void addItem(String item) {
            int val = items.getOrDefault(item, 0);
            items.put(item, val + 1);
        }
    }
    public List<List<String>> displayTable(List<List<String>> orders) {

        Map<Integer, Table> tableMap = new TreeMap<>();
        Set<String> foodSet = new TreeSet<>();

        for(List<String> order: orders) {
            int table = Integer.parseInt(order.get(1));
            String food = order.get(2);

            Table currentTable = tableMap.getOrDefault(table, new Table());
            currentTable.addItem(food);
            tableMap.put(table, currentTable);
            foodSet.add(food);
        }

        List<List<String>>  result = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(foodSet);
        result.add(header);

        for(Map.Entry<Integer, Table> table : tableMap.entrySet()) {
            int tableNo = table.getKey();
            List<String> curr = new ArrayList<>();
            curr.add(String.valueOf(tableNo));

            for(String food: foodSet) {
                curr.add(String.valueOf(table.getValue().items.getOrDefault(food, 0)));
            }
            result.add(curr);
        }
        return result;

    }

    public static void main(String[] args) {
        Prob2 prob2 = new Prob2();
        List<List<String>> input = new ArrayList<>();
//        input.add(Arrays.asList("David","3","Ceviche"));
//        input.add(Arrays.asList("Corina","10","Beef Burrito"));
//        input.add(Arrays.asList("David","3","Fried Chicken"));
//        input.add(Arrays.asList("Carla","5","Water"));
//        input.add(Arrays.asList("Carla","5","Ceviche"));
//        input.add(Arrays.asList("Rous","3","Ceviche"));
//        input.add(Arrays.asList("James","12","Fried Chicken"));
//        input.add(Arrays.asList("Ratesh","12","Fried Chicken"));
//        input.add(Arrays.asList("Amadeus","12","Fried Chicken"));
//        input.add(Arrays.asList("Adam","1","Canadian Waffles"));
//        input.add(Arrays.asList("Brianna","1","Canadian Waffles"));
//        input.add(Arrays.asList("Rous","3","Ceviche"));
        input.add(Arrays.asList("Laura","2","Bean Burrito"));
        input.add(Arrays.asList("Jhon","2","Beef Burrito"));
        input.add(Arrays.asList("Melissa","2","Soda"));

        PrintUtils.printStringListList(prob2.displayTable(input));
    }
}
