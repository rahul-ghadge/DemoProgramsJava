package com.demo.program.java8;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {
		
		// Supplier does not take any argument and returns expected value/object (same as Supplier<Long>)
		LongSupplier getCurrentTimeInMillis = () -> System.currentTimeMillis();
		
		// Get the value from supplier
		System.out.println("Milli secs : " + getCurrentTimeInMillis.getAsLong());
		
		
		
		Supplier<Date> getCurrentDate = () -> new Date();
		System.out.println("Today's Date : " + getCurrentDate.get());
		
		
		Supplier<SuperHero> deadPool = () -> new SuperHero("Wade", "Deadpool", "Street fighter", 28, true);
		System.out.println("Deadpool : " + deadPool.get());


		System.out.println();
		System.out.println("Super heroes :: " + superHeroSupplier().get());
				

	}

	public static Supplier<List<SuperHero>> superHeroSupplier() {

/*
//		Below line of code is same as commented code
		Supplier<List<SuperHero>> superHeroesSupplier = () -> Arrays.asList();
		return superHeroesSupplier;
*/


		return () ->
				Arrays.asList(
						new SuperHero("Bruce", "Hulk", "Doctor", 50, false),
						new SuperHero("Tony", "Iron Man", "Business man", 45, true),
						new SuperHero("Peter", "Spider Man", "Student", 21, true),
						new SuperHero("Steve", "Captain America", "Soldier", 70, false),
						new SuperHero("Wade", "Deadpool", "Street fighter", 30, true)
				);

	}

}







//		---------------------------------------------------------------
//		Output
//		---------------------------------------------------------------
//		Milli secs : 1600238214566
//		Today's Date : Wed Sep 16 12:06:54 IST 2020
//		Deadpool :
//		SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=28, canFly=true]
//
//		Super heroes :: [
//		SuperHero [name=Bruce, superName=Hulk, profession=Doctor, age=50, canFly=false],
//		SuperHero [name=Tony, superName=Iron Man, profession=Business man, age=45, canFly=true],
//		SuperHero [name=Peter, superName=Spider Man, profession=Student, age=21, canFly=true],
//		SuperHero [name=Steve, superName=Captain America, profession=Soldier, age=70, canFly=false],
//		SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=30, canFly=true]]
