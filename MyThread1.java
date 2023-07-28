public class MyThread1 extends Thread {
   final int a;

    public MyThread1(int a) {
        this.a = a;
    }


    @Override
    public void run() {
        for (int i = a; i <= 20; i++) {
            System.out.println("444444444444444444      "+i);

            print(i);
        }


    }

    private void print(int i) {
        System.out.println("555555555555555555   " +i * 2);
    }
}