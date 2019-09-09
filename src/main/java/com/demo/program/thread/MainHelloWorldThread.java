package com.demo.programs.threads;



public class MainHelloWorldThread {

	public static void main(String[] args) {

		HelloWorld helloWorld = new HelloWorld();

		Thread t1 = new Thread(() -> {
			try {
				helloWorld.printHello();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				helloWorld.printWorld();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		// printHello() will be called first
		t1.setPriority(Thread.MAX_PRIORITY);

		t1.start();
		t2.start();

	}
}

class HelloWorld {

	public void printHello() throws InterruptedException {

		synchronized (this) {
			// Infinite loop
			while (true) {
				// Sleep for 500ms
				Thread.sleep(500);
				System.out.print("Hello ");

				wait();
				// This thread will wait to call notify() from printWorld()

				notify();
				// This notify() will release lock on printWorld() thread
			}
		}
	}

	public void printWorld() throws InterruptedException {

		synchronized (this) {
			// Infinite loop
			while (true) {
				// Sleep for 100ms
				Thread.sleep(100);
				System.out.println("World");

				notify();
				// This notify() will release lock on printHello() thread

				wait();
				// This thread will wait to call notify() from printHello()
			}
		}
	}
}
