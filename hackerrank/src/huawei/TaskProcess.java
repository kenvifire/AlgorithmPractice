package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class TaskProcess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            int[] tasks = new int[n];
            for(int i = 0; i < n; i++) {
                tasks[i] = scanner.nextInt();
            }

            int[] cpuTime = new int[m];
            Arrays.sort(tasks);
            int index = 0;
            while (index < tasks.length) {

                int minCpuTime = cpuTime[0];
                int minIndex = 0;
                for(int i = 0; i < cpuTime.length; i++) {
                    if(cpuTime[i] < minCpuTime) {
                        minIndex = i;
                        minCpuTime = cpuTime[i];
                    }
                }
                cpuTime[minIndex] += tasks[index];
                index++;
            }

            System.out.println(Arrays.stream(cpuTime).max().getAsInt());

        }

    }
}
