package com.demo.program.java8;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferenceDemo {

    static Function<String, String> f1 = name -> name.toUpperCase();
    static Function<String, String> f2 = String::toUpperCase;

    static Predicate<SuperHero> p1 = hero -> hero.getAge() >= 30;
    static Predicate<SuperHero> p2 = MethodReferenceDemo::ageCheck;
    static BiPredicate<SuperHero, Integer> p3 = MethodReferenceDemo::ageCheckWithParam;
    static Function<String, String> f3 = MethodReferenceDemo::sayMyName;
    static Supplier<SuperHero> deadPool = () -> new SuperHero("Wade", "Deadpool", "Street fighter", 28, true);
    static Comparator<Integer> comp = MethodReferenceDemo::compare;

    public static void main(String[] args) {
        System.out.println("Lambda Expression Result :"+f1.apply("iron Man"));
        System.out.println("Method Reference Result :"+f2.apply("iron Man"));
        System.out.println("Predicate 1 Result :" + p1.test(deadPool.get()));
        System.out.println("Predicate 2 Result :" + p2.test(deadPool.get()));
        System.out.println("Predicate 3 Result :" + p3.test(deadPool.get(), 30));
        System.out.println("Function Test :" + f3.apply("Stark"));

        System.out.println("Result 4 :" + MethodReferenceDemo.compare(10, 20));
        System.out.println("Result 5:" + comp.compare(10, 20));
    }

    static boolean ageCheck(SuperHero hero) {
        return hero.getAge() >= 30;
    }

    static boolean ageCheckWithParam(SuperHero hero, Integer age) {
        return hero.getAge() >= age;
    }

    static String sayMyName(String name) {
        return "Hello Mr. " + name;
    }

    public static int compare(Integer x, Integer y) {
        return Integer.compare(x, y);
    }
}
