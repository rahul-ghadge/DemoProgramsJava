package com.demo.program.thread;


class Produssor {


    public void produce() throws InterruptedException {

        synchronized (this){
            System.out.println("*** We are in produce method...!");
            wait();
            System.out.println("*** After wait method...!");
        }
    }


    public void consumer() throws InterruptedException {

        Thread.sleep(3000);
        synchronized (this){
            System.out.println("### We are in consumer method...!");
            notify();
            Thread.sleep(100);
            System.out.println("### After notify method...!");
        }
    }

}


public class WaitNotifyTest {

    public static void main(String[] args) {
        Produssor p = new Produssor();

        Thread t1 = new Thread(() -> {
           try {
               for (int i = 0; i < 3 ; i++) {
                   p.produce();
               }

           }catch (InterruptedException e){
               e.printStackTrace();
           }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 3 ; i++) {
                    p.consumer();
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished...!");
    }
}
