public class MyThread_1 extends Thread {
    private String name;

    public MyThread_1(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 200; i++) {
            System.out.println(name + ": " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread_1 t1 = new MyThread_1("Thread 11111");
        MyThread_1 t2 = new MyThread_1("Thread 222222222222");
        MyThread_1 t3 = new MyThread_1("Thread 33333333333333333");

        t1.start();

        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t1.join();

//        try {
////            t1.join();
////            t2.join();
////            t3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("All threads have finished");
}
}