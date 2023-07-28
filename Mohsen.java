public class Mohsen {
    public static void main(String[] args) {

        int a = 10;

        MyThread2 t2 = new MyThread2();
        MyThread1 t1 = new MyThread1(a);
        // Start the thread
        t1.start();

        // Wait for the thread to finish
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread1 has finished");
        // Start the thread
        t2.start();

        // Wait for the thread to finish
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread2 has finished");
    }
}