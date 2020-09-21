package jdk.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    private static CountDownLatch startSignal = new CountDownLatch(1);
    private static CountDownLatch endSignal = new CountDownLatch(6);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 6; i ++) {
            executorService.execute(() -> {
                try {
                    System.out.println("Awaiting start signal:" );
                    startSignal.await();
//                    Thread.sleep(new Random().nextInt(200));
                    System.out.println("Working in progress" );
                    endSignal.countDown();
                    System.out.println("Finished:");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("Start signal");
        startSignal.countDown();
        endSignal.await();
        System.out.println("all finished");
        executorService.shutdown();
    }


}
