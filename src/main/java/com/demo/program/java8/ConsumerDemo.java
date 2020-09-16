package com.demo.program.java8;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerDemo {

	public static void main(String[] args) {


		// Supplier will supply Deadpool and Consumer will consume Deadpool data
		Supplier<SuperHero> deadPool = () -> new SuperHero("Wade", "Deadpool", "Street fighter", 28, true);
		
		Consumer<SuperHero> superHeroConsumer = (hero) -> System.out.println(hero);
		superHeroConsumer.accept(deadPool.get());
		
		
		
		Supplier<Date> getCurrentDate = () -> new Date();
		
		Consumer<Date> dateConsumer = (date) -> System.out.println(date);
		dateConsumer.accept(getCurrentDate.get());
		
		
		
		
		Consumer<String> stringConsumer = (name) -> System.out.println(name + " is awesome");
		stringConsumer.accept("Tony");


		// Consumer chaining
		Consumer<String> upperCaseConsumer = (str) -> System.out.println(str.toUpperCase() + " in uppercase");
		stringConsumer.andThen(upperCaseConsumer).accept("tony");
		
	}

}






//		---------------------------------------------------------------
//		Output
//		---------------------------------------------------------------
//		SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=28, canFly=true]
//		Wed Sep 16 12:15:26 IST 2020
//		Tony is awesome
//		tony is awesome
//		TONY in uppercase