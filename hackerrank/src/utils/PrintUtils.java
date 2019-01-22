package utils;


import java.util.List;

public class PrintUtils {
   public static void printArray(int[] array)  {
      for (int i = 0; i < array.length; i++) {
         System.out.printf("%d ", array[i]);
      }
      System.out.println();
   }

   public static void printList(List<Integer> list) {
      for (int i : list) {
         System.out.printf("%d ", i) ;
      }
      System.out.println();
   }
}
