package com.demo.program.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReturnValueFromCollable {

	public static void main(String[] args) {
		
		try {
			
			// Java 7
			ExecutorService service = Executors.newSingleThreadExecutor();
			Future<String> future = service.submit(new MyCollable());
			System.out.println("Tony " + future.get());	
			
			
			// Java 8
			Future<String> whoIsNotAwesome = service.submit(() -> "is not god");
			System.out.println("Loki " + whoIsNotAwesome.get());
			
			
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} 
	}

}



class MyCollable implements Callable<String> {
	
	public String call() {
		return "is awesome";
	}
	
}
