package com.demo.program.java8;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String[] args) {

        Supplier<List<SuperHero>> superHeroSupplier = SupplierDemo.superHeroSupplier();

        System.out.println("-------------- Ages Operations using Collectors class ---------------------");
        agesOperations(superHeroSupplier.get());

        System.out.println("\n\n-------------- Names Operations using Collectors joining method ---------------------");
        namesJoining(superHeroSupplier.get());

        System.out.println("\n\n-------------- GroupingBy Operations of Collectors class ---------------------");
        groupingByOperations(superHeroSupplier.get());

        System.out.println("\n\n-------------- PartitioningBy Operations of Collectors class ---------------------");
        partitioningByOperations(superHeroSupplier.get());

    }


    static void agesOperations(List<SuperHero> superHeroes) {

        long sumOfAges = superHeroes.stream()
                .filter(hero -> hero.isCanFly())
                .collect(Collectors.summingLong(SuperHero::getAge));
        System.out.println("Sum of Ages (can fly) :: " + sumOfAges);


        List<Integer> agesList = superHeroes.stream()
                .filter(hero -> hero.isCanFly())
                .collect(Collectors.mapping(SuperHero::getAge, Collectors.toList()));
        System.out.println("\nAges list (can fly) :: " + agesList);


        double avgOfAges = superHeroes.stream()
                //.filter(hero -> hero.isCanFly())
                .collect(Collectors.averagingDouble(SuperHero::getAge));
        System.out.println("\nAverage of Ages :: " + avgOfAges);


        long canFlyCount = superHeroes.stream()
                .filter(hero -> hero.isCanFly())
                .collect(Collectors.counting());
        System.out.println("\nCan fly count :: " + canFlyCount);


        Optional<SuperHero> seniorSuperHero = superHeroes.stream()
                //.filter(hero -> hero.isCanFly())
                .collect(Collectors.maxBy(Comparator.comparing(SuperHero::getAge)));
        System.out.println("\nSenior Super Hero :: " + seniorSuperHero.get());


        Optional<SuperHero> juniorSuperHero = superHeroes.stream()
                //.filter(hero -> hero.isCanFly())
                .collect(Collectors.minBy(Comparator.comparing(SuperHero::getAge)));
        System.out.println("\nJunior Super Hero :: " + juniorSuperHero.get());

    }

    static void namesJoining(List<SuperHero> superHeroes) {

        String names = superHeroes.stream()
                //.filter(hero -> hero.isCanFly())
                .map(SuperHero::getName)
                .collect(Collectors.joining());
        System.out.println("Names :: " + names);


        String namesWithDelimiter = superHeroes.stream()
                //.filter(hero -> hero.isCanFly())
                .map(SuperHero::getName)
                .collect(Collectors.joining("-"));
        System.out.println("\n\nNames with Delimiter :: " + namesWithDelimiter);


        String namesWithPrefixSuffiX = superHeroes.stream()
                //.filter(hero -> hero.isCanFly())
                .map(SuperHero::getName)
                .collect(Collectors.joining("-", "[", "]"));
        System.out.println("\n\nNames with Prefix & Suffix :: " + namesWithPrefixSuffiX);

    }


    static void groupingByOperations(List<SuperHero> superHeroes) {
        Map<Boolean, List<SuperHero>> heroes = superHeroes.stream().collect(Collectors.groupingBy(SuperHero::isCanFly));
        System.out.println("Super Heroes group by flying category");
        //heroes.forEach((x, y) -> System.out.println(x + " -> " + y));
        heroes.entrySet().forEach(System.out::println);


        Map<String, List<SuperHero>> flyOrNot = superHeroes.stream()
                .collect(Collectors.groupingBy(hero -> hero.isCanFly() ? "Fly" : "Can't fly"));
        System.out.println("\n\nSuper Heroes can fly or Not");
        //flyOrNot.forEach((x, y) -> System.out.println(x + " -> " + y));
        flyOrNot.entrySet().forEach(System.out::println);


        Map<Boolean, Map<String, List<SuperHero>>> flyOrNotByAge = superHeroes.stream()
                .collect(Collectors.groupingBy(SuperHero::isCanFly, Collectors.groupingBy(hero -> hero.getAge() > 40 ? "Senior" : "Junior")));
        System.out.println("\n\nSuper Heroes can fly or Not with Senior and Junior (2 level Grouping)");
        //flyOrNotByAge.forEach((x, y) -> System.out.println(x + " -> " + y));
        flyOrNotByAge.entrySet().forEach(System.out::println);


        Map<String, Integer> ageSumBySrJr = superHeroes.stream()
                .collect(Collectors.groupingBy(hero -> hero.getAge() > 40 ? "Senior" : "Junior", Collectors.summingInt(SuperHero::getAge)));
        System.out.println("\n\nSuper Heroes age sum with Senior and Junior");
        //ageSumBySrJr.forEach((x, y) -> System.out.println(x + " -> " + y));
        ageSumBySrJr.entrySet().forEach(System.out::println);


        Map<Integer, List<SuperHero>> superHeroesWithAge = superHeroes.stream()
                .collect(Collectors.groupingBy(SuperHero::getAge, HashMap::new, Collectors.toList()));
        System.out.println("\n\nSuper Heroes HashMap with age key");
        //superHeroesWithAge.forEach((x, y) -> System.out.println(x + " -> " + y));
        superHeroesWithAge.entrySet().forEach(System.out::println);


        Map<Boolean, List<SuperHero>> superHeroesWithFly = superHeroes.stream()
                .collect(Collectors.groupingBy(SuperHero::isCanFly, HashMap::new, Collectors.toList()));

        System.out.println("\n\nSuper Heroes HashMap with canFly key");
        //superHeroesWithFly.forEach((x, y) -> System.out.println(x + " -> " + y));
        superHeroesWithFly.entrySet().forEach(System.out::println);

    }


    static void partitioningByOperations(List<SuperHero> superHeroes) {

        Predicate<SuperHero> canFlyPredicate = hero -> hero.isCanFly();

        Map<Boolean, List<SuperHero>> superHeroesCaFly = superHeroes.stream().collect(Collectors.partitioningBy(canFlyPredicate));
        System.out.println("Super Heroes Map with canFly key");
        superHeroesCaFly.entrySet().forEach(System.out::println);


        Map<Boolean, Set<SuperHero>> superHeroesCaFlySet = superHeroes.stream()
                .collect(Collectors.partitioningBy(canFlyPredicate, Collectors.toSet()));
        System.out.println("\n\nSuper Heroes Map of Set with canFly key");
        superHeroesCaFlySet.entrySet().forEach(System.out::println);


        Map<Boolean, Map<String, Integer>> superHeroesCaFlyMap = superHeroes.stream()
                .collect(Collectors.partitioningBy(canFlyPredicate, Collectors.toMap(SuperHero::getName, SuperHero::getAge)));
        System.out.println("\n\nSuper Heroes Map(key=canFly, value=Map) of Map(Key=Name, value=Age)");
        superHeroesCaFlyMap.entrySet().forEach(System.out::println);
    }

}









//		  ---------------------------------------------------------------
//		  Output
//		  ---------------------------------------------------------------
//
//        -------------- Ages Operations using Collectors class ---------------------
//        Sum of Ages (can fly) :: 96
//
//        Ages list (can fly) :: [45, 21, 30]
//
//        Average of Ages :: 43.2
//
//        Can fly count :: 3
//
//        Senior Super Hero :: SuperHero [name=Steve, superName=Captain America, profession=Soldier, age=70, canFly=false]
//
//        Junior Super Hero :: SuperHero [name=Peter, superName=Spider Man, profession=Student, age=21, canFly=true]
//
//
//        -------------- Names Operations using Collectors joining method ---------------------
//        Names :: BruceTonyPeterSteveWade
//
//
//        Names with Delimiter :: Bruce-Tony-Peter-Steve-Wade
//
//
//        Names with Prefix & Suffix :: [Bruce-Tony-Peter-Steve-Wade]
//
//
//        -------------- GroupingBy Operations of Collectors class ---------------------
//        Super Heroes group by flying category
//        false=[SuperHero [name=Bruce, superName=Hulk, profession=Doctor, age=50, canFly=false], SuperHero [name=Steve, superName=Captain America, profession=Soldier, age=70, canFly=false]]
//        true=[SuperHero [name=Tony, superName=Iron Man, profession=Business man, age=45, canFly=true], SuperHero [name=Peter, superName=Spider Man, profession=Student, age=21, canFly=true], SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=30, canFly=true]]
//
//
//        Super Heroes can fly or Not
//        Fly=[SuperHero [name=Tony, superName=Iron Man, profession=Business man, age=45, canFly=true], SuperHero [name=Peter, superName=Spider Man, profession=Student, age=21, canFly=true], SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=30, canFly=true]]
//        Can't fly=[SuperHero [name=Bruce, superName=Hulk, profession=Doctor, age=50, canFly=false], SuperHero [name=Steve, superName=Captain America, profession=Soldier, age=70, canFly=false]]
//
//
//        Super Heroes can fly or Not with Senior and Junior (2 level Grouping)
//        false={Senior=[SuperHero [name=Bruce, superName=Hulk, profession=Doctor, age=50, canFly=false], SuperHero [name=Steve, superName=Captain America, profession=Soldier, age=70, canFly=false]]}
//        true={Junior=[SuperHero [name=Peter, superName=Spider Man, profession=Student, age=21, canFly=true], SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=30, canFly=true]], Senior=[SuperHero [name=Tony, superName=Iron Man, profession=Business man, age=45, canFly=true]]}
//
//
//        Super Heroes age sum with Senior and Junior
//        Junior=51
//        Senior=165
//
//
//        Super Heroes HashMap with age key
//        50=[SuperHero [name=Bruce, superName=Hulk, profession=Doctor, age=50, canFly=false]]
//        21=[SuperHero [name=Peter, superName=Spider Man, profession=Student, age=21, canFly=true]]
//        70=[SuperHero [name=Steve, superName=Captain America, profession=Soldier, age=70, canFly=false]]
//        45=[SuperHero [name=Tony, superName=Iron Man, profession=Business man, age=45, canFly=true]]
//        30=[SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=30, canFly=true]]
//
//
//        Super Heroes HashMap with canFly key
//        false=[SuperHero [name=Bruce, superName=Hulk, profession=Doctor, age=50, canFly=false], SuperHero [name=Steve, superName=Captain America, profession=Soldier, age=70, canFly=false]]
//        true=[SuperHero [name=Tony, superName=Iron Man, profession=Business man, age=45, canFly=true], SuperHero [name=Peter, superName=Spider Man, profession=Student, age=21, canFly=true], SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=30, canFly=true]]
//
//
//        -------------- PartitioningBy Operations of Collectors class ---------------------
//        Super Heroes Map with canFly key
//        false=[SuperHero [name=Bruce, superName=Hulk, profession=Doctor, age=50, canFly=false], SuperHero [name=Steve, superName=Captain America, profession=Soldier, age=70, canFly=false]]
//        true=[SuperHero [name=Tony, superName=Iron Man, profession=Business man, age=45, canFly=true], SuperHero [name=Peter, superName=Spider Man, profession=Student, age=21, canFly=true], SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=30, canFly=true]]
//
//
//        Super Heroes Map of Set with canFly key
//        false=[SuperHero [name=Bruce, superName=Hulk, profession=Doctor, age=50, canFly=false], SuperHero [name=Steve, superName=Captain America, profession=Soldier, age=70, canFly=false]]
//        true=[SuperHero [name=Tony, superName=Iron Man, profession=Business man, age=45, canFly=true], SuperHero [name=Peter, superName=Spider Man, profession=Student, age=21, canFly=true], SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=30, canFly=true]]
//
//
//        Super Heroes Map(key=canFly, value=Map) of Map(Key=Name, value=Age)
//        false={Bruce=50, Steve=70}
//        true={Tony=45, Wade=30, Peter=21}
//
