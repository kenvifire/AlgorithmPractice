package contest.backrockcodesprint;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/12.
 */
public class FixedIncomeAlloc {
    static class Order implements Comparable<Order>{
        String id;
        long order;
        long amount;

        @Override
        public int compareTo(Order o) {
            if(order  == o.order) {
                return id.compareTo(o.id);
            }else {
                return  order - o.order > 0 ? 1 : -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        long increment, mininum_trade_size, avaliable_units;
        long totalOrder = 0;
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
            order.order = Long.valueOf(arr[1]);

            totalOrder += order.order;

            orderList[i] = order;
        }

        Arrays.sort(orderList);
        double proportional_allocation = 0;
        double half_min_trade_size = mininum_trade_size / 2.0;
        long int_alloc;
        //
        for (Order order : orderList) {
            if(avaliable_units < mininum_trade_size) {
                order.amount = 0;
                continue;
            }
            proportional_allocation = order.order * avaliable_units / (totalOrder * 1.0);
            if(proportional_allocation >= mininum_trade_size) {
                if(proportional_allocation >= order.order) {
                    order.amount = order.order;
                }else {
                    int_alloc = (long) Math.floor(proportional_allocation);
                    long amount = mininum_trade_size + (int_alloc - mininum_trade_size) / increment * increment;
                    while (amount >= mininum_trade_size) {
                        if((order.order - amount - mininum_trade_size)  % increment == 0)  break;
                        amount -= increment;
                    }
                    if(amount >= mininum_trade_size) {
                        order.amount = amount;
                    }else {
                        order.amount = 0;
                    }
                }

            } else {
                if(proportional_allocation > half_min_trade_size) {
                    if(order.order>= 2* mininum_trade_size && (order.order - 2 * mininum_trade_size) % increment == 0) {
                        order.amount = mininum_trade_size;
                    }else {
                        order.amount = 0;
                    }
                }else{
                    order.amount = 0;
                }
            }
            avaliable_units -= order.amount;
            totalOrder -= order.order;

        }

        Arrays.sort(orderList, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.id.compareTo(o2.id);
            }
        });

        for (Order order : orderList) {
            System.out.println(order.id + " " + order.amount);
        }

    }
}
