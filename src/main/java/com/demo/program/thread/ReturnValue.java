package com.demo.program.thread;

interface MyInterface {
    void m1(int a);
}



public class ReturnValue implements MyInterface {

    public static void main(String[] args) {
        new ReturnValue().callMethod();
    }

    void callMethod() {
        MyThread myThread = new MyThread(this);
        myThread.start();
    }

    @Override
    public void m1(int a) {
        System.out.println("value " + a);
    }
}

class MyThread extends Thread {

    MyInterface myInterface;

    MyThread(MyInterface myInterfaceRef) {
        this.myInterface = myInterfaceRef;
    }

    @Override
    public void run() {
        myInterface.m1(10);
    }
}
