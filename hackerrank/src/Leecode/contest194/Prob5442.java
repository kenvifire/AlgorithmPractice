package Leecode.contest194;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob5442 {
    public int[] avoidFlood(int[] rains) {

        int[] result = new int[rains.length];
        Map<Integer, Integer> rainMap = new HashMap<>();
        Map<Integer, Integer> prevRain = new HashMap<>();
        int nonRainPointer = 0;
        List<Integer> nonRainList = new ArrayList<>();

        for(int i = 0; i < rains.length; i++) {

            int rain = rains[i];
            if(rain == 0 ) {
                nonRainList.add(i);
                continue;
            }

            if(rain > 0) {
                result[i] = -1;
            }
            int value = rainMap.getOrDefault(rain, 0) + 1;
            rainMap.put(rain, value);

            if(value == 1) {
                prevRain.put(rain, i);
            }

            if(value >= 2) {
                if(nonRainList.size() <= 0 ) return new int[]{};//flood
                else {
                    boolean flag = false;
                    nonRainPointer = 0;

                    while(nonRainPointer < nonRainList.size()) {
                        int nonRain = nonRainList.get(nonRainPointer);
                        if (nonRain > prevRain.get(rain) && nonRain < i) {
                            result[nonRainList.get(nonRainPointer)] = rain;
                            prevRain.put(rain, i);
                            rainMap.put(rain, 1);
                            result[nonRainList.get(nonRainPointer)] = rain;
                            nonRainList.remove(nonRainPointer);
                            flag = true;

                            break;
                        }
                        nonRainPointer++;

                    }
                    if(!flag ) {
                        return new int[]{};
                    }

                }
            }
        }

        for(int i = 0; i < result.length; i++) {
            if(result[i] == 0) result[i] = 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Prob5442 prob5442 = new Prob5442();
//        prob5442.avoidFlood(new int[] {1,0,2,0,2,1});
//        prob5442.avoidFlood(new int[] {1,2,0,0,2,1  });

//        prob5442.avoidFlood(new int[] {1,2,0,1,2 });

//        prob5442.avoidFlood(new int[] {69,0,0,0,69 });
//        prob5442.avoidFlood(new int[] {10,20,20 });
        prob5442.avoidFlood(new int[] {2,3,0,0,3,1,0,1,0,2,2});


    }
}
