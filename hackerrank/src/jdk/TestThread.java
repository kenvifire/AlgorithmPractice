package jdk;

/**
 * Created by kenvi on 16/8/12.
 */
public class TestThread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("start");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e) {}
                t.interrupt();
            }
        });
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
