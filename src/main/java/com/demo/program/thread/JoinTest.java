package com.demo.program.thread;


class Runner1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //System.out.println("Runner 1 :: " + i);

            System.out.print("Hello");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Runner2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
           // System.out.println("Runner 2 :: " + i);
            System.out.println(" World");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



class Thread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread 1 :: " + i);
        }
    }
}

class Thread2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread 2 :: " + i);
        }
    }
}

public class JoinTest {

    public static void main(String[] args) {
        Thread r1 = new Thread(new Runner1());
        Thread r2 = new Thread(new Runner2());

        r1.start();
        r2.start();

        //Thread1 t1 = new Thread1();
        //Thread2 t2 = new Thread2();

        //t1.start();
        //t2.start();

    }
}
