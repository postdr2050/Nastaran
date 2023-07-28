import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class WordCounter {

    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        
        String filename = "data1.txt";
        String wordToCount = "West";
        AtomicInteger count = new AtomicInteger(0);

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

            for (int i = 0; i < NUM_THREADS; i++) {
                executor.execute(new WordCountTask(reader, wordToCount, count));
            }

            executor.shutdown();
            while (!executor.isTerminated()) {
                // wait for all threads to finish
            }

            System.out.println("The word '" + wordToCount + "' appeared " + count.get() + " times in the file.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static class WordCountTask implements Runnable {

        private final BufferedReader reader;
        private final String wordToCount;
        private final AtomicInteger count;

        public WordCountTask(BufferedReader reader, String wordToCount, AtomicInteger count) {
            this.reader = reader;
            this.wordToCount = wordToCount;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] words = line.split(" ");
                    for (String word : words) {
                        if (word.equalsIgnoreCase(wordToCount)) {
                            count.incrementAndGet();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}