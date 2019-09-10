package com.demo.program.thread;


class HelloWorldClass {


    public void hello() throws InterruptedException {

        synchronized (this){
            System.out.print("Hello");
            wait();
        }
    }


    public void world() throws InterruptedException {

        Thread.sleep(50);
        synchronized (this){
            System.out.println(" World");
            notify();
        }
    }

}


public class HelloWorldPrint {

    public static void main(String[] args) {
    	HelloWorldClass helloWorldClass = new HelloWorldClass();

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 100 ; i++) {
                	helloWorldClass.hello();
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 100 ; i++) {
                	helloWorldClass.world();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();

/*
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished...!");*/
    }
}
