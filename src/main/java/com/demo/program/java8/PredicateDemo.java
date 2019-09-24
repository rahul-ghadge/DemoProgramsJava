package com.demo.program.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {

		
		// Predicate to recruit super hero who can fly and not too old
		Predicate<SuperHero> canJoinAvengers = hero -> hero.isCanFly() && hero.getAge() < 55;
		
		
		// Super hero list
		List<SuperHero> superHeros = new ArrayList<>();

		SuperHero hulk = new SuperHero("Bruce", "Hulk", "Doctor", 50, false);
		SuperHero capAmerica = new SuperHero("Steve", "Captain America", "Solder", 120, false);
		SuperHero ironMan = new SuperHero("Tony", "Iron Man", "Business man", 45, true);
		SuperHero spiderMan = new SuperHero("Peter", "Spider Man", "Student", 21, true);

		// adding all super hero into list
		superHeros.add(hulk);
		superHeros.add(capAmerica);
		superHeros.add(ironMan);
		superHeros.add(spiderMan);

		

		// Java 7
		for (SuperHero superHero : superHeros) {
			// checking super hero criteria to join Avengers
			if (canJoinAvengers.test(superHero))
				System.out.println(superHero.getName() + " can join Avengers.");
		}


		// Java 8
		System.out.println("-----------------------");
		superHeros
				.stream()
				.filter(canJoinAvengers) // checking super hero criteria to join Avengers
				.forEach(
						hero -> System.out.println(hero.getName()
								+ " can join Avengers."));
		
		
		
		// Predicate to recruit super hero who can fly and not too old 
		// OR 
		// is doctor who can help in Lab 
		Predicate<SuperHero> isDoctor = hero -> hero.getProfession().equalsIgnoreCase("doctor");		
		Predicate<SuperHero> canHelpInLab = canJoinAvengers.or(isDoctor);
		
		
		// Java 7
		System.out.println("-----------------------");
		for (SuperHero superHero : superHeros) {
			// checking super hero criteria to join Avengers
			if (canHelpInLab.test(superHero))
				System.out.println(superHero.getName() + " can join Avengers.");
		}
		
	}

}

