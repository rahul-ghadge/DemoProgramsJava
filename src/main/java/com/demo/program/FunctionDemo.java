package com.demo.program;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {

	public static void main(String[] args) {

		Function<SuperHero, String> superHeroName = (hero) -> hero.getName().toUpperCase();
		
		

		// Super hero list
		List<SuperHero> superHeros = new ArrayList<>();

		SuperHero hulk = new SuperHero("Bruce", "Hulk", "Doctore", 50, false);
		SuperHero capAmerica = new SuperHero("Steve", "Captain America", "Solder", 120, false);
		SuperHero ironMan = new SuperHero("Tony", "Iron Man", "Business man", 45, true);
		SuperHero spiderMan = new SuperHero("Peter", "Spider Man", "Student", 21, true);

		// adding all super hero into list
		superHeros.add(hulk);
		superHeros.add(capAmerica);
		superHeros.add(ironMan);
		superHeros.add(spiderMan);

		// Java 7
		for (SuperHero hero : superHeros) {
			System.out.println(superHeroName.apply(hero));
		}
		
		// Java 8
		System.out.println("--------------");
		superHeros
				.stream()
				.map(superHeroName)
				.forEach(nameInUpperCase -> System.out.println(nameInUpperCase));		
		
		
		
		// Adding multiple Functions using andThen() method
		Function<String, Integer> superHeroAge = (name) -> name.length();		
		Function<SuperHero, Integer> superHeroLength =  superHeroName.andThen(superHeroAge);
		

		// Java 7
		System.out.println("--------------");
		for (SuperHero hero : superHeros) {
			System.out.println("Length of name : " + superHeroLength.apply(hero));
		}
		
		
		// Java 8
		System.out.println("--------------");		
		superHeros
				.stream()
				.map(superHeroLength)
				.forEach(count -> System.out.println("Length of name : " + count));

	}

}
