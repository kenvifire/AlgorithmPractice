package contest.hackerrank_hiring_contest;

import java.util.Scanner;

/**
 * Created by kenvi on 2018/1/27.
 */
public class WinningLotteryTicket {
    private static final int WIN = 1023;

    static int ticketToBit(String ticket) {
        int bit = 0;

        for (int i = 0; i < ticket.length(); i++) {
            char c = ticket.charAt(i);
            switch (c) {
                case '0':
                    bit |= 1;
                    break;
                case '1':
                    bit |= 2;
                    break;
                case '2':
                    bit |= 4;
                    break;
                case '3':
                    bit |= 8;
                    break;
                case '4':
                    bit |= 16;
                    break;
                case '5':
                    bit |= 32;
                    break;
                case '6':
                    bit |= 64;
                    break;
                case '7':
                    bit |= 128;
                    break;
                case '8':
                    bit |= 256;
                    break;
                case '9':
                    bit |= 512;
                    break;
            }
            if (bit == WIN) return bit;
        }
        return bit;

    }

    static long winningLotteryTicket(String[] tickets) {
        long[] ticketBits = new long[1024];

        for (int i = 0; i < tickets.length; i++) {
            int tickBit = ticketToBit(tickets[i]);
            ticketBits[tickBit] = ticketBits[tickBit] + 1;
        }

        long count = 0;
        if(ticketBits[1023] > 0) {
            long fullCnt = ticketBits[1023];
            count = fullCnt * (tickets.length - fullCnt) + (fullCnt * (fullCnt - 1) /2);
        }
        for (int i = 1; i < 1022; i++) {
            for (int j = i+1; j < 1023; j++) {
                if ((i | j) == WIN) {
                    count += (ticketBits[i] * ticketBits[j]);
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] tickets = new String[n];
        for(int tickets_i = 0; tickets_i < n; tickets_i++){
            tickets[tickets_i] = in.next();
        }
        long result = winningLotteryTicket(tickets);
        System.out.println(result);
        in.close();
    }
}
