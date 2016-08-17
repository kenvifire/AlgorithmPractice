package algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kenvi on 16/8/17.
 */
public class JimAndTheOrders {
    static class Order implements Comparable<Order>{
        int index;
        int t,d;
        public int getTime() {
            return t + d;
        }
        @Override
        public int compareTo(Order o) {
            if(this.getTime() == o.getTime()) {
                return this.index - o.index;
            }else {
                return this.getTime() - o.getTime();
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Order> orderList = new ArrayList<>(n);
        for (int i = 0; i <n ; i++) {
            Order order = new Order();
            order.t = scanner.nextInt();
            order.d = scanner.nextInt();
            order.index = i;

            orderList.add(order);
        }

        Collections.sort(orderList);

        for (Order order: orderList) {
            System.out.printf(order.index+1 + " ");
        }

    }
}
