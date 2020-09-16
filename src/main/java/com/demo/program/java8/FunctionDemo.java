package com.demo.program.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {

	public static void main(String[] args) {

		Function<SuperHero, String> superHeroName = (hero) -> hero.getName().toUpperCase();
		

		// Super hero list
		List<SuperHero> superHeroes = new ArrayList<>();

		SuperHero hulk = new SuperHero("Bruce", "Hulk", "Doctor", 50, false);
		SuperHero capAmerica = new SuperHero("Steve", "Captain America", "Solder", 120, false);
		SuperHero ironMan = new SuperHero("Tony", "Iron Man", "Business man", 45, true);
		SuperHero spiderMan = new SuperHero("Peter", "Spider Man", "Student", 21, true);

		// adding all super hero into list
		superHeroes.add(hulk);
		superHeroes.add(capAmerica);
		superHeroes.add(ironMan);
		superHeroes.add(spiderMan);

		// Java 7
		for (SuperHero hero : superHeroes) {
			System.out.println(superHeroName.apply(hero));
		}
		
		// Java 8
		System.out.println("--------------");
		superHeroes
				.stream()
				.map(superHeroName)
				.forEach(nameInUpperCase -> System.out.println(nameInUpperCase));		
		
		
		
		// Adding multiple Functions using andThen() method
		Function<String, Integer> superHeroAge = (name) -> name.length();		
		Function<SuperHero, Integer> superHeroLength =  superHeroName.andThen(superHeroAge);
		

		// Java 7
		System.out.println("--------------");
		for (SuperHero hero : superHeroes) {
			System.out.println("Length of name : " + superHeroLength.apply(hero));
		}
		
		
		// Java 8
		System.out.println("--------------");
		superHeroes
				.stream()
				.map(superHeroLength)
				.forEach(count -> System.out.println("Length of name : " + count));
		
		
		// Predicate to return same entity/identity
		Function<SuperHero, SuperHero> superHero = Function.identity();
		
		
		// Java 7
		System.out.println("--------------");	
		for (SuperHero hero : superHeroes) {
			System.out.println(superHero.apply(hero));
		}
		
		
		// Java 8
		System.out.println("--------------");
		superHeroes
				.stream()
				.map(superHero)
				.forEach(System.out::println);	

	}

}





//		---------------------------------------------------------------
//		Output
//		---------------------------------------------------------------
//		BRUCE
//		STEVE
//		TONY
//		PETER
//		--------------
//		BRUCE
//		STEVE
//		TONY
//		PETER
//		--------------
//		Length of name : 5
//		Length of name : 5
//		Length of name : 4
//		Length of name : 5
//		--------------
//		Length of name : 5
//		Length of name : 5
//		Length of name : 4
//		Length of name : 5
//		--------------
//
//		SuperHero [name=Bruce, superName=Hulk, profession=Doctor, age=50, canFly=false]
//
//		SuperHero [name=Steve, superName=Captain America, profession=Solder, age=120, canFly=false]
//
//		SuperHero [name=Tony, superName=Iron Man, profession=Business man, age=45, canFly=true]
//
//		SuperHero [name=Peter, superName=Spider Man, profession=Student, age=21, canFly=true]
//		--------------
//
//		SuperHero [name=Bruce, superName=Hulk, profession=Doctor, age=50, canFly=false]
//
//		SuperHero [name=Steve, superName=Captain America, profession=Solder, age=120, canFly=false]
//
//		SuperHero [name=Tony, superName=Iron Man, profession=Business man, age=45, canFly=true]
//
//		SuperHero [name=Peter, superName=Spider Man, profession=Student, age=21, canFly=true]
