package com.demo.program.runtime;

import java.util.ArrayList;
import java.util.List;

public class GarbageCollectionDemo {

	public static void main(String[] args) {
		
		Runtime runtime = Runtime.getRuntime();
		//long freeMemory = runtime.freeMemory();
		
		System.out.println("Available space :: " + runtime.freeMemory() / 1024 + " kb");
		
		
		List<String> list = new ArrayList<>();
		System.out.println("Available space :: " + runtime.freeMemory() / 1024 + " kb");
		
		
		for (int i = 0; i < 1000000; i++) {
			list.add("string-" + i);
		}
		System.out.println("Available space :: " + runtime.freeMemory() / 1024 + " kb");
		
		
		list = null;
		//Runtime.getRuntime().gc();
		System.gc();
		System.out.println("Available space :: " + runtime.freeMemory() / 1024 + " kb");
		
	}
}

// -------------------------------
// Output (o/p can vary as per system config)
// -------------------------------
// Available space :: 124620 kb
// Available space :: 124620 kb
// Available space :: 80423 kb
// Available space :: 157623 kb
