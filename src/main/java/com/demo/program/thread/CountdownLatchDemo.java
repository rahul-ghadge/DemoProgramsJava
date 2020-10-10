package com.demo.program.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatchDemo {

    public static void main(String[] args) {

        ExecutorService service = Executors.newSingleThreadExecutor();
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 1; i <= 5; i++) {
            service.submit(new Worker(i, countDownLatch));
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks are done executing...");
        service.shutdown();

    }
}


class Worker implements Runnable {

    private int id;
    private CountDownLatch countDownLatch;

    public Worker(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Thread with ID " + id + " starts the task...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countDownLatch.countDown();
    }


    @Override
    public String toString() {
        return "Worker{" + "id=" + id + '}';
    }
}


//        Output::

//        Thread with ID 1 starts the task...
//        Thread with ID 2 starts the task...
//        Thread with ID 3 starts the task...
//        Thread with ID 4 starts the task...
//        Thread with ID 5 starts the task...
//        All tasks are done executing...