package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManage {

    static class BookRequest {
        int bookPrice;
        int requestDays;
        int actualDays;

        public BookRequest(int bookPrice, int requestDays, int actualDays) {
           this.bookPrice = bookPrice;
           this.requestDays = requestDays;
           this.actualDays = actualDays;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;
        List<BookRequest> bookRequestList = new ArrayList<>();

        //input process
        while (scanner.hasNext()) {
            line = scanner.next();
            String[] nums = line.split(",");

            BookRequest bookRequest = new BookRequest(Integer.valueOf(nums[0]), Integer.valueOf(nums[1]),
                    Integer.valueOf(nums[2]));
            bookRequestList.add(bookRequest);
        }

        //actual logic
       int balance = 300;

        for (BookRequest bookRequest : bookRequestList) {
            //skip if balance less than book price
            balance = handleBookRequest(bookRequest, balance);
        }

        System.out.println(balance);


    }

    public static int handleBookRequest(BookRequest bookRequest, int balance) {
        int bookPrice = bookRequest.bookPrice;
        int requestDays = bookRequest.requestDays;
        int actualDays = bookRequest.actualDays;

        if(bookPrice > balance) {
            return balance;
        } else {
            int requestPrice = 0;

            if(bookPrice >= 100) {
                if(actualDays <= 15) {
                    requestPrice += 5 * actualDays;
                } else {
                    requestPrice += 15 * 5 + (actualDays - 15) * 3;
                }

            } else if(bookPrice >= 50) {
               if(actualDays <= 15) {
                   requestPrice += 3 * actualDays;
               } else {
                   requestPrice += 15 * 3 + (actualDays - 15) * 2;
               }
            } else {
                requestPrice = actualDays;
            }

            if(requestPrice > bookPrice) {
                requestPrice = bookPrice;
            }

            if(requestDays < actualDays)  {
                balance -= (actualDays - requestDays);
            }
            return balance - requestPrice;
        }

    }



}
