package jdk.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue taskQueue = new ArrayBlockingQueue<Integer>(10);
        Thread t1 = new Thread(new Producer(taskQueue));
        Thread t2 = new Thread(new Consumer(taskQueue));
        t1.start();
        t2.start();

    }

    static class Producer implements Runnable {
        private BlockingQueue<Integer> taskQueue;
        private int count = 0;

        Producer(BlockingQueue<Integer> taskQueue) {
            this.taskQueue = taskQueue;
        }

        @Override
        public void run() {
            while(count < 100) {
                try {
                    taskQueue.put(1);
                    Thread.sleep(100);
                    taskQueue.put(2);
                    Thread.sleep(100);
                    taskQueue.put(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count += 3;
            }
        }
    }

    static class Consumer implements Runnable {
        private BlockingQueue<Integer> taskQueue;
        Consumer(BlockingQueue<Integer> taskQueue) {
            this.taskQueue = taskQueue;
        }
        @Override
        public void run() {
            while (!taskQueue.isEmpty()) {
                try {
                    System.out.println(taskQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
