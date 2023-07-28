import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread_4 extends Thread {
    private static int counter = 0;
    private static Lock lock = new ReentrantLock();

    public void run() {
        for (int i = 1; i <= 5; i++) {
            lock.lock();

            try {
                System.out.println(Thread.currentThread().getName() + " - Counter value: " + counter);
                counter++;
            } finally {
                lock.unlock();
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread_4 t1 = new MyThread_4();
        MyThread_4 t2 = new MyThread_4();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + counter);
    }
}