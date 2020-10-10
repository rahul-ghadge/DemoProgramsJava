package com.demo.program.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,
                () -> System.out.println("All tasks are done executing..."));

        for (int i = 1; i <= 5; i++) {
            service.execute(new CyclicBarrierWorker(i, cyclicBarrier));
        }

        service.shutdown();
    }

}


class CyclicBarrierWorker implements Runnable {

    private int id;
    private CyclicBarrier cyclicBarrier;
    private Random random;

    public CyclicBarrierWorker(int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
        this.random = new Random();
    }


    @Override
    public void run() {
        System.out.println("Thread with ID " + id + " starts the task...");

        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread with ID " + id + " Finished...");

        try {
            cyclicBarrier.await();

            System.out.println("After await ID " + id);

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}



//        Output ::

//        Thread with ID 1 starts the task...
//        Thread with ID 2 starts the task...
//        Thread with ID 3 starts the task...
//        Thread with ID 4 starts the task...
//        Thread with ID 5 starts the task...
//        Thread with ID 1 Finished...
//        Thread with ID 3 Finished...
//        Thread with ID 4 Finished...
//        Thread with ID 2 Finished...
//        Thread with ID 5 Finished...
//        All tasks are done executing...
//        After await ID 5
//        After await ID 3
//        After await ID 1
//        After await ID 4
//        After await ID 2
