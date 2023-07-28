public class MyThread_2 extends Thread {
    private  static int counter = 0;

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Counter value: " + counter);
            counter++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread_2 t1 = new MyThread_2();
        MyThread_2 t2 = new MyThread_2();
        MyThread_2 t3 = new MyThread_2();

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + t1.counter);
    }
}