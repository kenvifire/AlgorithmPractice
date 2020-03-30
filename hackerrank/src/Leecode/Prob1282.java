package Leecode;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prob1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groupMap = new HashMap<>();

        IntStream.range(0, groupSizes.length)
            .forEach(idx -> {
                List<Integer> groupList = groupMap.getOrDefault(groupSizes[idx], new ArrayList<>());
                groupList.add(idx);
                groupMap.put(groupSizes[idx], groupList);
            });

        List<List<Integer>> result = new ArrayList<>();

        groupMap.forEach((key, value) -> {
            for (int i = 0; i < value.size(); i+= key) {
                result.add(value.subList(i, i + key));
            }
        });

        return result;
    }

    public static void main(String[] args) {
        Prob1282 solve = new Prob1282();
        PrintUtils.printIntListList(solve.groupThePeople(new int[] {2,1,3,3,3,2}));
    }
}
