public class MyThread_3 extends Thread {
    private static int counter = 0;
    private static Object lock = new Object();

    public void run() {
        for (int i = 1; i <= 5; i++) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " - Counter value: " + counter);
                counter++;

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }


        }
    }

    public static void main(String[] args) {
        MyThread_3 t1 = new MyThread_3();
        MyThread_3 t2 = new MyThread_3();
        MyThread_3 t3 = new MyThread_3();

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + counter);
    }
}