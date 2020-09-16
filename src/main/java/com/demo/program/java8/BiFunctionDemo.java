package com.demo.program.java8;

import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class BiFunctionDemo {

    public static void main(String[] args) {

        Supplier<List<SuperHero>> superHeroSupplier = SupplierDemo.superHeroSupplier();

        System.out.println("********* BiFunction example *********");
        biFunctional(superHeroSupplier);

        System.out.println();

        System.out.println("********* UnaryOperator example *********");
        unaryOperator(superHeroSupplier);

        System.out.println();

        System.out.println("********* BinaryOperator example *********");
        binaryOperator();

    }

    private static void biFunctional(Supplier<List<SuperHero>> superHeroSupplier) {


        // Predicate to recruit super hero who can fly and not too old
        Predicate<SuperHero> canJoinAvengers = hero -> hero.isCanFly() && hero.getAge() < 55;
        //
        BiFunction<List<SuperHero>, Predicate<SuperHero>, List<String>> superHeroName = (heroes, predicate) ->
            heroes.stream()
                    .filter(predicate)
                    .map(superHero -> superHero.getName().toUpperCase())
                    .collect(Collectors.toList());


        List<String> superHeroNamesInUpper = superHeroName.apply(superHeroSupplier.get(), canJoinAvengers);
        System.out.println("Super heroes list who can fly and whose age is less than 55");
        System.out.println(superHeroNamesInUpper);
    }





    private static void unaryOperator(Supplier<List<SuperHero>> superHeroSupplier) {


        UnaryOperator<String> nameUnaryOperator = name -> name.toUpperCase();
        System.out.println(nameUnaryOperator.apply("aryan"));
        System.out.println();


        // Super hero name and super name in upper case using UnaryOperator
        UnaryOperator<SuperHero> superHeroUnaryOperator = superHero -> {
            superHero.setName(superHero.getName().toUpperCase());
            superHero.setSuperName(superHero.getSuperName().toUpperCase());
            return superHero;
        };


        // Applying UnaryOperator function in map method
        List<SuperHero> superHeroNamesInUpper = superHeroSupplier.get()
                .stream()
                .map(superHeroUnaryOperator)
                .collect(Collectors.toList());

        System.out.println("Super heroes list with name in Upper case");
        System.out.println(superHeroNamesInUpper);

    }







    private static void binaryOperator() {

        Comparator<Integer> comparator = Comparator.naturalOrder();

        BinaryOperator<Integer> binaryOperatorMax = BinaryOperator.maxBy(comparator);
        System.out.println("Max :: " + binaryOperatorMax.apply(100, 50));


        BinaryOperator<Integer> binaryOperatorMin = BinaryOperator.minBy(comparator);
        System.out.println("Min :: " + binaryOperatorMin.apply(100, 50));

    }

}






//		  ---------------------------------------------------------------
//		  Output
//		  ---------------------------------------------------------------
//        ********* BiFunction example *********
//        Super heroes list who can fly and whose age is less than 55
//        [TONY, PETER, WADE]
//
//        ********* UnaryOperator example *********
//        ARYAN
//
//        Super heroes list with name in Upper case
//        [
//        SuperHero [name=BRUCE, superName=HULK, profession=Doctor, age=50, canFly=false],
//        SuperHero [name=TONY, superName=IRON MAN, profession=Business man, age=45, canFly=true],
//        SuperHero [name=PETER, superName=SPIDER MAN, profession=Student, age=21, canFly=true],
//        SuperHero [name=STEVE, superName=CAPTAIN AMERICA, profession=Soldier, age=70, canFly=false],
//        SuperHero [name=WADE, superName=DEADPOOL, profession=Street fighter, age=30, canFly=true]]
//
//        ********* BinaryOperator example *********
//        Max :: 100
//        Min :: 50
