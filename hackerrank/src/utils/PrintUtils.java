package utils;


import java.util.List;

public class PrintUtils {
    public static void printArray(int[] array) {
        System.out.printf("[");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println("]");
    }

    public static void printArray(int[][] arry) {
        for (int[] arr : arry) {
            printArray(arr);
        }
    }

    public static void printArray(String[] array) {
        System.out.printf("[");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s ", array[i]);
        }
        System.out.println("]");
    }

    public static void printIntList(List<Integer> list) {
        System.out.printf("[");
        for (int i : list) {
            System.out.printf("%d ", i);
        }
        System.out.printf("]");
        System.out.println();
    }

    public static void printStringList(List<String> list) {
        for (String str : list) {
            System.out.printf("\"%s\" ", str);
        }
        System.out.println();
    }

    public static void printStringListList(List<List<String>> list) {
        for (List<String> l : list) {
            printStringList(l);
        }
    }

    public static void printIntListList(List<List<Integer>> list) {
        for (List<Integer> l : list) {
            printIntList(l);
        }
    }
}
