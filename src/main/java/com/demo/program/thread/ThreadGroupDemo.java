package com.demo.program.thread;

public class ThreadGroupDemo {
    public static void main(String[] args) {


        ThreadGroup threadGroup = new ThreadGroup("test");


        Thread t1 = new Thread(threadGroup, "t1");
        Thread t2 = new Thread(threadGroup, "t2");

        threadGroup.list();

        threadGroup.setMaxPriority(3);

        Thread t3 = new Thread(threadGroup, "t3");
        t3.setPriority(10);

        threadGroup.list();

        System.out.println(t1.getName() + " : " + t1.getPriority());
        System.out.println(t2.getName() + " : " + t2.getPriority());
        System.out.println(t3.getName() + " : " + t3.getPriority());


    }
}
