package com.demo.program;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {

		
		// Predicate to recruit super hero who can fly and not too old
		Predicate<SuperHero> canJoinAvengers = hero -> hero.canFly && hero.age < 55;
		
		
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
		for (SuperHero superHero : superHeros) {
			// checking super hero criteria to join Avengers
			if (canJoinAvengers.test(superHero))
				System.out.println(superHero.name + " can join Avengers.");
		}

		System.out.println("-----------------------");

		// Java 8
		superHeros
				.stream()
				.filter(canJoinAvengers) // checking super hero criteria to join Avengers
				.forEach(
						hero -> System.out.println(hero.name
								+ " can join Avengers."));
	}

}

class SuperHero {

	String name;
	String superName;
	String profession;
	int age;
	boolean canFly;

	public SuperHero(String name, String superName, String profession, int age,
			boolean canFly) {
		super();
		this.name = name;
		this.superName = superName;
		this.profession = profession;
		this.age = age;
		this.canFly = canFly;
	}
}
