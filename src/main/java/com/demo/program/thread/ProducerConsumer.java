package com.demo.program.thread;


import java.util.ArrayList;
import java.util.List;

class Process {

    public final int LIMIT;
    public final int BOTTOM;
    private final Object lock = new Object();
    private int value = 0;
    public final List<Integer> list = new ArrayList<>();

    Process(int limit) {
        this.LIMIT = limit;
        this.BOTTOM = 0;
    }

    public void producer() throws InterruptedException {

        synchronized (lock) {

            while (true) {

                if (list.size() == LIMIT) {
                    System.out.println("Waiting for remove Items from list...");
                    lock.wait();
                } else {
                    System.out.println("Adding : " + value);
                    list.add(value);
                    value++;
                    lock.notifyAll();
                }
                Thread.sleep(500);

            }

        }

    }


    public void consumer() throws InterruptedException {

        synchronized (lock) {

            while (true) {

                if (list.size() == BOTTOM) {
                    System.out.println("Waiting for add Items in list...");
                    lock.wait();
                } else {
                    System.out.println("Removing Item from List : " + list.remove(--value));
                    lock.notify();
                }
                Thread.sleep(500);

            }

        }


    }
}


public class ProducerConsumer {

    public static void main(String[] args) {


        Process process = new Process(10);

        Thread t1 = new Thread(() -> {
            try {
                process.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                process.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }

}

