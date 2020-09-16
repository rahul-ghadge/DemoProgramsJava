package com.demo.program.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class BiConsumerDemo {

    public static void main(String[] args) {



        BiConsumer<String, Integer> biConsumer = (str, num) -> {
            System.out.println("String : " + str);
            System.out.println("Number : " + num);
        };

        biConsumer.accept("This is String", 100);




        // Getting list of super heroes from as supplier from Supplier class
        Supplier<List<SuperHero>> superHeroesSupplier = SupplierDemo.superHeroSupplier();

        // Printing super hero whose Super name is 'Iron man'
        BiConsumer<List<SuperHero>, String> biConsumerIronMan = (superHeroes, superName) ->
                superHeroes.forEach(superHero -> {
                    if (superHero.getSuperName().equalsIgnoreCase(superName)) {
                        System.out.println(superHero);
                    }
                });

        biConsumerIronMan.accept(superHeroesSupplier.get(), "Iron man");








        List<SuperHero> validSuperHero = new ArrayList<>();

        // Printing super hero whose age less than 50
        BiConsumer<List<SuperHero>, Integer> biConsumerLessThan50 = (superHeroes, age) ->
                superHeroes.forEach(superHero -> {
                    if (superHero.getAge() < age) {
                        // Adding valid super heroes to list
                        validSuperHero.add(superHero);
                    }
                });

        biConsumerLessThan50.accept(superHeroesSupplier.get(), 50);
        System.out.println("*** Filtered Super Heroes ***\n");
        System.out.println(validSuperHero);

    }
}






//		---------------------------------------------------------------
//		Output
//		---------------------------------------------------------------
//      String : This is String
//      Number : 100
//
//      SuperHero [name=Tony, superName=Iron Man, profession=Business man, age=45, canFly=true]
//      *** Filtered Super Heroes ***
//
//      [
//      SuperHero [name=Tony, superName=Iron Man, profession=Business man, age=45, canFly=true],
//      SuperHero [name=Peter, superName=Spider Man, profession=Student, age=21, canFly=true],
//      SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=30, canFly=true]]
