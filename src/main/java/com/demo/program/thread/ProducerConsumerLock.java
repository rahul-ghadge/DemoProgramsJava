package com.demo.program.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ProcessLock {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void producer() throws InterruptedException {
        lock.lock();
        System.out.println("Producer is called...!");
        condition.await();
        System.out.println("Again producer is called...!");
        lock.unlock();

    }

    public void consumer() throws InterruptedException {

        lock.lock();
        System.out.println("Consumer is called...!");
        condition.signal();
        System.out.println("Consumer called signal method..!");
        lock.unlock();
    }

}
public class ProducerConsumerLock {

    public static void main(String[] args) {


        ProcessLock process = new ProcessLock();

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

        t1.start();
        t2.start();
    }
}
