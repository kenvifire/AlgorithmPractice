package contest.backrockcodesprint;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/12.
 */
public class FixedIncomeAlloc {
    static class Order implements Comparable<Order>{
        String id;
        int order;
        int amount;

        @Override
        public int compareTo(Order o) {
            if(order  == o.order) {
                return id.compareTo(o.id);
            }else {
                return  order - o.order;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        int increment, mininum_trade_size, avaliable_units;
        int totalOrder = 0;
        Order[] orderList = new Order[T];
        mininum_trade_size = scanner.nextInt();
        increment = scanner.nextInt();
        avaliable_units = scanner.nextInt();

        scanner.nextLine();
        String line = null;
        String[] arr;

        for (int i = 0; i < T; i++) {
            line = scanner.nextLine();
            arr = line.split(" ");
            Order order = new Order();
            order.id = arr[0];
            order.order = Integer.valueOf(arr[1]);

            totalOrder += order.order;

            orderList[i] = order;
        }

        Arrays.sort(orderList);
        double proportional_allocation = 0;
        double half_min_trade_size = mininum_trade_size / 1.0;
        int int_alloc;
        //
        for (Order order : orderList) {
            if(avaliable_units < mininum_trade_size) {
                order.amount = 0;
                continue;
            }
            proportional_allocation = order.order * avaliable_units / (totalOrder * 1.0);
            if(proportional_allocation >= mininum_trade_size) {
                int_alloc = (int) proportional_allocation;


            } else if(proportional_allocation > half_min_trade_size ) {
                if(avaliable_units >= mininum_trade_size) {
                    order.amount = mininum_trade_size;
                }else {
                    order.amount = 0;
                }
            }else {
                order.amount = 0;
            }
            avaliable_units -= order.amount;
            totalOrder -= order.order;

        }

    }
}
