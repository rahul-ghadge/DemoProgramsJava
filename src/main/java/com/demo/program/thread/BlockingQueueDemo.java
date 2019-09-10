package com.demo.program.thread;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class BlockingQueueWorker1 implements Runnable {

    BlockingQueue<Integer> blockingQueue;

    BlockingQueueWorker1(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        int counter = 0;

        while (true) {

            try {

                System.out.println("Adding :" + counter);
                blockingQueue.put(counter);
                counter++;
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}




class BlockingQueueWorker2 implements Runnable {

    BlockingQueue<Integer> blockingQueue;

    BlockingQueueWorker2(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        while (true) {

            try {
                System.out.println("Taking :" + blockingQueue.take());
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class BlockingQueueDemo {
    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        //BlockingQueueWorker1 bq1

        new Thread(new BlockingQueueWorker1(queue)).start();
        new Thread(new BlockingQueueWorker2(queue)).start();

    }
}
