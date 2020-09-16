package com.demo.program.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class BiPredicateDemo {

    public static void main(String[] args) {


        BiPredicate<SuperHero, List<String>> biPredicate = (superHero, superNames) -> superNames.contains(superHero.getSuperName());


        List<String> superNames = Arrays.asList("Iron Man", "Spider Man");
        Supplier<List<SuperHero>> superHeroSupplier = SupplierDemo.superHeroSupplier();


        // Print super heroes matching super names from above list (superNames)
        superHeroSupplier.get()
                .stream()
                .filter(s -> biPredicate.test(s, superNames))
                .forEach(System.out::print);

        System.out.println();


        /*
        *
        * Same as Predicate BiPredicate has 'and()', 'or()' and 'negate()' methods
        * Check Predicate.java class for reference
        *
        */

    }
}





//		---------------------------------------------------------------
//		Output
//		---------------------------------------------------------------
//      SuperHero [name=Tony, superName=Iron Man, profession=Business man, age=45, canFly=true]
//      SuperHero [name=Peter, superName=Spider Man, profession=Student, age=21, canFly=true]