public class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("**************  " + i);
        }
    }

}
