package com.demo.program;

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
		
		
		
		
		Consumer<String> StringConsumer = (name) -> System.out.println(name + " is awesome");
		StringConsumer.accept("Tony");
		
	}

}
