package com.demo.program.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableSumOfRange implements Runnable {
    private final long countUntil;

    RunnableSumOfRange(long countUntil) {
        this.countUntil = countUntil;
    }

    @Override
    public void run() {
        long sum = 0;
        for (long i = 1; i < countUntil; i++) {
            sum += i;
        }
        System.out.println(sum);
    }







    public static void main(String[] args) {
//        // We will store the threads so that we can check if they are done
//        List<Thread> threads = new ArrayList<>();
//        // We will create 500 threads
//        for (int i = 0; i < 500; i++) {
//            Runnable task = new RunnableSumOfRange(10000000L + i);
//            Thread t = new Thread(task);
//            // We can set the name of the thread
//            t.setName(String.valueOf(i));
//            // Start the thread, never call method run() direct
//            t.start();
//            // Remember the thread for later usage
//            threads.add(t);
//        }
//
//
//        int running = 0;
//        do {
//            running = 0;
//            for (Thread thread : threads) {
//                if (thread.isAlive()) {
//                    running++;
//                }
//            }
//            System.out.println("We have " + running + " running threads. ");
//        } while (running > 0);
//
//  //  }
//


     final int NTHREDS = 10;



 //   public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        for (int i = 0; i < 500; i++) {
            Runnable worker = new RunnableSumOfRange(10000000L + i);
            executor.execute(worker);
        }


        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();


        // Wait until all threads are finish
        //executor.awaitTermination();

        System.out.println("Finished all threads");

    }
}

