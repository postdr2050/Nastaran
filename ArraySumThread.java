public class ArraySumThread extends Thread {
    private long[] array;
    private int startIndex;
    private int endIndex;
    private static long totalSum = 0;
    private static Object lock = new Object();

    public ArraySumThread(long[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public void run() {
        long sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += array[i];
        }

        synchronized(lock) {
            totalSum += sum;
        }
    }

    public static void main(String[] args) {
        int numThreads = 2;
        int arraySize = 500;
        long[] array = new long[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = i;
        }

        int blockSize = arraySize / numThreads;
        ArraySumThread[] threads = new ArraySumThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * blockSize;
            int endIndex = (i == numThreads-1) ? arraySize-1 : (i+1) * blockSize - 1;
            threads[i] = new ArraySumThread(array, startIndex, endIndex);
            threads[i].start();
        }

        try {
            for (int i = 0; i < numThreads; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total sum: " + totalSum);
    }
}