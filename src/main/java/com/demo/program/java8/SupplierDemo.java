package com.demo.program.java8;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {
		
		// Supplier does not take any argument and returns expected value/object
		Supplier<Long> getCurrentTimeInMillis = () -> System.currentTimeMillis();
		
		// Get the value from supplier
		System.out.println(getCurrentTimeInMillis.get());
		
		
		
		Supplier<Date> getCurrentDate = () -> new Date();
		System.out.println("Todays Date : " + getCurrentDate.get());
		
		
		Supplier<SuperHero> deadPool = () -> new SuperHero("Wade", "Deadpool", "Street fighter", 28, true);
		System.out.println("Deadpool : " + deadPool.get());
				

	}

}
