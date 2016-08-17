package algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kenvi on 16/8/17.
 */
public class MarkAndToys {
    public static void main(String[] args) {
        Scanner stdin=new Scanner(System.in);
        int n=stdin.nextInt(),k=stdin.nextInt();
        int prices[]=new int[n];
        for(int i=0;i<n;i++) prices[i]=stdin.nextInt();

        int answer = 0;
        // Compute the final answer from n,k,prices
        Arrays.sort(prices);
        int i = 0;
        while(k > 0 && i <n) {
            if(k >= prices[i]) {
                answer+=1;
                k -= prices[i];
                i++;
            }else {
                break;
            }
        }
        System.out.println(answer);
    }
}
