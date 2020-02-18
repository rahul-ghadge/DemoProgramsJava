package com.demo.program.comparatr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ComparatorDemo {

	public static void main(String[] args) {

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
		
		// ---------------------------------------------------
		System.out.println("\n\n*****  Java_7 ASC sorting super heros by superName  *****");
		// Java_7 ASC sorting super heros by superName
		Comparator<SuperHero> superNameComaparatorJava_7 = new Comparator<SuperHero>() {
			@Override
			public int compare(SuperHero hero1, SuperHero hero2){
				return hero1.getSuperName().compareTo(hero2.getSuperName());				
			}
		};		
		Collections.sort(superHeros, superNameComaparatorJava_7);
		System.out.println(superHeros);
		
		
		
		// ---------------------------------------------------
		System.out.println("\n\n*****  Java_8 ASC sorting super heros by superName  *****");
		// Java_7 ASC sorting super heros by superName
		Comparator<SuperHero> superNameComaparatorJava_8 = (hero1, hero2)-> hero1.getSuperName().compareTo(hero2.getSuperName());				
			
		Collections.sort(superHeros, superNameComaparatorJava_8);
		System.out.println(superHeros);		
				
		
		
		// ---------------------------------------------------
		System.out.println("\n\n*****  Sort super heros in DESC order by age  *****");
		// Sort super heros in DESC order by age
		Comparator<SuperHero> compareByName = Comparator.comparing(e -> e.getAge());
		Collections.sort(superHeros, compareByName.reversed());
		System.out.println(superHeros);
		
		
		
		// ---------------------------------------------------
		System.out.println("\n\n*****  Sort super heros in ASC order by real life name  *****");
		// Sort super heros in ASC order by real life name
		superHeros.sort(Comparator.comparing(s -> s.getName()));
		System.out.println(superHeros);
		
		
		
		// ---------------------------------------------------
		System.out.println("\n\n*****  Sort super heros by multiple condition  *****");
		/*
		 * Sort super heros by multiple condition
		 * 		1: DESC - sort by real life name then
		 * 		2: ASC - sort by profession and then
		 * 		3: ASC - sort by super name 
		 */
		Comparator<SuperHero> groupByComparator = Comparator.comparing(SuperHero::getName).reversed()
                .thenComparing(SuperHero::getProfession)
                .thenComparing(SuperHero::getSuperName);
		superHeros.sort(groupByComparator);
		System.out.println(superHeros);
	}
}
