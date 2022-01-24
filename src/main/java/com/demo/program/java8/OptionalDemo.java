package com.demo.program.java8;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class OptionalDemo {

    public static void main(String[] args) {

        emptyOptional();
        ofOptional();
        ofNullableOptional();
        isPresentOptional();
        ifPresentOptional();
        filterOptional();
        mapOptional();
        flatmapOptional();
        orElseOptional();
        orElseGetOptional();
        orElseThrowOptional();

    }



    private static void emptyOptional() {
        System.out.println("\n*** Optional empty() ***");
        Optional<String> optionalString = Optional.empty();
        System.out.println(optionalString);
    }



    private static void ofOptional() {
        System.out.println("\n*** Optional of() & get() ***");
        Optional<String> optionalString = Optional.of("This is simple string");
        System.out.println(optionalString.get());

        Optional<Supplier<List<SuperHero>>> optionalSuperHeroSupplier = Optional.of(SupplierDemo.superHeroSupplier());
        System.out.println(optionalSuperHeroSupplier.get().get());  // 1st get() from Optional
                                                                    // 2nd get() from Supplier
    }



    private static void ofNullableOptional() {
        System.out.println("\n*** Optional ofNullable() & get() ***");

        Optional<String> optionalString = Optional.ofNullable(null);
        System.out.println(optionalString);

        Optional<Supplier<List<SuperHero>>> optionalSuperHeroSupplier = Optional.ofNullable(null);
        System.out.println(optionalSuperHeroSupplier);
    }



    private static void isPresentOptional() {
        System.out.println("\n*** Optional isPresent() & get() ***");
        Optional<String> optionalNullString = Optional.empty();
        if (optionalNullString.isPresent()) {
            System.out.println("Empty string isPresent(): " + optionalNullString.get());
        } else {
            System.out.println("No value is present in optional");
        }

        Optional<String> optionalString = Optional.of("I love coding");
        if (optionalString.isPresent()) {
            System.out.println("String isPresent(): " + optionalString.get());
        } else {
            System.out.println("No value is present in optional");
        }

        Optional<Supplier<List<SuperHero>>> optionalSuperHeroSupplier = Optional.ofNullable(SupplierDemo.superHeroSupplier());
        if (optionalSuperHeroSupplier.isPresent()) {
            /*
             * Below single line of code is same as commented code:
             *       Supplier<List<SuperHero>> optionalSupplier = optionalSuperHeroSupplier.get();
             *       List<SuperHero> superHeroes = optionalSupplier.get();
             *       superHeroes.forEach(System.out::println);
             */
            optionalSuperHeroSupplier.get().get().forEach(System.out::println);
        }
    }



    private static void ifPresentOptional() {
        System.out.println("\n*** Optional ifPresent() & get() ***");

        BiFunction<String, Locale, String> stringUpperCaser = String::toUpperCase;

        Optional<String> optionalString = Optional.of("I love coding");
        optionalString.ifPresent(str -> {
            System.out.println("Upper case string: " + stringUpperCaser.apply(str, Locale.ROOT));   // String -> toUpperCase()
        });
        

        optionalString.ifPresent(str -> {
            System.out.println("String length: " + str.length());  // printing String length
        });

        System.out.println("\n*** SuperHero ifPresent() ***");
        Optional<Supplier<List<SuperHero>>> optionalSuperHeroSupplier = Optional.ofNullable(SupplierDemo.superHeroSupplier());
        optionalSuperHeroSupplier.ifPresent(heroList -> {
            heroList.get()                          // Get Superhero list from using optional.get()
                    .forEach(superHero -> {         // Iterate over Superheroes list
                        superHero.setName(superHero.getName().toUpperCase(Locale.ROOT));    // Superhero name -> toUpperCase
                        System.out.println(superHero);
                    });
        });

    }



    private static void filterOptional() {
        System.out.println("\n*** Optional of(), filter(), ifPresent(), get() & String.toUpperCase() ***");

        Optional<Supplier<List<SuperHero>>> optionalSuperHeroSupplier = Optional.of(SupplierDemo.superHeroSupplier());

        optionalSuperHeroSupplier
                .filter(listSupplier -> !listSupplier.get().isEmpty())  // Filter only if Superhero list is non-empty
                .ifPresent(listSupplier -> {
                    listSupplier.get()
                            .forEach(superHero -> {
                                superHero.setName(superHero.getName().toUpperCase(Locale.ROOT));
                                System.out.println(superHero);
                            });
                });
    }



    private static void mapOptional() {
        System.out.println("\n*** Optional of(), filter(), map(), ifPresent() & String.toUpperCase() ***");

        Optional<Supplier<List<SuperHero>>> optionalSuperHeroSupplier = Optional.of(SupplierDemo.superHeroSupplier());

        optionalSuperHeroSupplier
                //.filter(listSupplier -> !listSupplier.get().isEmpty()) // optional filter
                .map(Supplier::get) // same as "map(listSupplier -> listSupplier.get())"
                .ifPresent(superHeroes -> {
                    superHeroes.forEach(superHero -> {
                        superHero.setName(superHero.getName().toUpperCase(Locale.ROOT));
                        System.out.println(superHero);
                    });
                });
    }



    private static void flatmapOptional() {
        System.out.println("\n*** Optional of(), flatMap() & get() ***");
        System.out.println("*** flatMap() is used for Optional of Optional ***");

        Optional<String> optionalString = Optional.of("I love coding");
        Optional<Optional<String>> optionalOptionalString = Optional.of(optionalString); // Optional of Optional string

        String str = optionalOptionalString
                .flatMap(optionalStr -> optionalStr)
                .get();
        System.out.println("String in upper case: " + str.toUpperCase(Locale.ROOT));
    }



    private static void orElseOptional() {
        System.out.println("\n*** Optional of() & orElse() ***");

        String str = Optional.of("I love coding")
                .orElse("I have to learn coding");
        System.out.println(str);

        String strNullable = (String) Optional.ofNullable(null)
                .orElse("I have to learn coding");
        System.out.println(strNullable);

        Supplier<List<SuperHero>> superHeroSupplier = Optional.of(SupplierDemo.superHeroSupplier())
                .orElse(Collections::emptyList);
        System.out.println(superHeroSupplier.get());

        List<SuperHero> superHeroes = (List<SuperHero>) Optional.ofNullable(null)
                .orElse(Collections.emptyList());
        System.out.println(superHeroes);
    }



    private static void orElseGetOptional() {
        System.out.println("\n*** Optional of() & orElseGet() ***");

        String str = Optional.of("I love coding")
                .orElseGet(() -> "I have to learn coding");
        System.out.println(str);

        String strNullable = (String) Optional.ofNullable(null)
                .orElseGet(() -> "I have to learn coding");
        System.out.println(strNullable);

        Supplier<List<SuperHero>> superHeroSupplier = Optional.of(SupplierDemo.superHeroSupplier())
                .orElseGet(() -> Collections::emptyList);
        System.out.println(superHeroSupplier.get());

        List<SuperHero> superHeroes = (List<SuperHero>) Optional.ofNullable(null)
                .orElseGet(() -> Collections.emptyList());
        System.out.println(superHeroes);
    }



    private static void orElseThrowOptional() {
        System.out.println("\n*** Optional empty() & orElseThrow() ***");

        try {
            Optional<String> emptyString = Optional.empty();
            emptyString.orElseThrow(() -> new RuntimeException("Empty String found"));
        } catch (Exception ex) {
            System.out.println("** Printing exception **");
            ex.printStackTrace();
        }
    }

}






//		  ---------------------------------------------------------------
//		  Output
//		  ---------------------------------------------------------------
//        *** Optional empty() ***
//        Optional.empty
//
//        *** Optional of() & get() ***
//        This is simple string
//        [SuperHero [name=Bruce, superName=Hulk, profession=Doctor, age=50, canFly=false], SuperHero [name=Tony, superName=Iron Man, profession=Business man, age=45, canFly=true], SuperHero [name=Peter, superName=Spider Man, profession=Student, age=21, canFly=true], SuperHero [name=Steve, superName=Captain America, profession=Soldier, age=70, canFly=false], SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=30, canFly=true]]
//
//        *** Optional ofNullable() & get() ***
//        Optional.empty
//        Optional.empty
//
//        *** Optional isPresent() & get() ***
//        No value is present in optional
//        String isPresent(): I love coding
//        SuperHero [name=Bruce, superName=Hulk, profession=Doctor, age=50, canFly=false]
//        SuperHero [name=Tony, superName=Iron Man, profession=Business man, age=45, canFly=true]
//        SuperHero [name=Peter, superName=Spider Man, profession=Student, age=21, canFly=true]
//        SuperHero [name=Steve, superName=Captain America, profession=Soldier, age=70, canFly=false]
//        SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=30, canFly=true]
//
//        *** Optional ifPresent() & get() ***
//        Upper case string: I LOVE CODING
//        String length: 13
//
//        *** SuperHero ifPresent() ***
//        SuperHero [name=BRUCE, superName=Hulk, profession=Doctor, age=50, canFly=false]
//        SuperHero [name=TONY, superName=Iron Man, profession=Business man, age=45, canFly=true]
//        SuperHero [name=PETER, superName=Spider Man, profession=Student, age=21, canFly=true]
//        SuperHero [name=STEVE, superName=Captain America, profession=Soldier, age=70, canFly=false]
//        SuperHero [name=WADE, superName=Deadpool, profession=Street fighter, age=30, canFly=true]
//
//        *** Optional of(), filter(), ifPresent(), get() & String.toUpperCase() ***
//        SuperHero [name=BRUCE, superName=Hulk, profession=Doctor, age=50, canFly=false]
//        SuperHero [name=TONY, superName=Iron Man, profession=Business man, age=45, canFly=true]
//        SuperHero [name=PETER, superName=Spider Man, profession=Student, age=21, canFly=true]
//        SuperHero [name=STEVE, superName=Captain America, profession=Soldier, age=70, canFly=false]
//        SuperHero [name=WADE, superName=Deadpool, profession=Street fighter, age=30, canFly=true]
//
//        *** Optional of(), filter(), map(), ifPresent() & String.toUpperCase() ***
//        SuperHero [name=BRUCE, superName=Hulk, profession=Doctor, age=50, canFly=false]
//        SuperHero [name=TONY, superName=Iron Man, profession=Business man, age=45, canFly=true]
//        SuperHero [name=PETER, superName=Spider Man, profession=Student, age=21, canFly=true]
//        SuperHero [name=STEVE, superName=Captain America, profession=Soldier, age=70, canFly=false]
//        SuperHero [name=WADE, superName=Deadpool, profession=Street fighter, age=30, canFly=true]
//
//        *** Optional of(), flatMap() & get() ***
//        *** flatMap() is used for Optional of Optional ***
//        String in upper case: I LOVE CODING
//
//        *** Optional of() & orElse() ***
//        I love coding
//        I have to learn coding
//        [SuperHero [name=Bruce, superName=Hulk, profession=Doctor, age=50, canFly=false], SuperHero [name=Tony, superName=Iron Man, profession=Business man, age=45, canFly=true], SuperHero [name=Peter, superName=Spider Man, profession=Student, age=21, canFly=true], SuperHero [name=Steve, superName=Captain America, profession=Soldier, age=70, canFly=false], SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=30, canFly=true]]
//        []
//
//        *** Optional of() & orElseGet() ***
//        I love coding
//        I have to learn coding
//        [SuperHero [name=Bruce, superName=Hulk, profession=Doctor, age=50, canFly=false], SuperHero [name=Tony, superName=Iron Man, profession=Business man, age=45, canFly=true], SuperHero [name=Peter, superName=Spider Man, profession=Student, age=21, canFly=true], SuperHero [name=Steve, superName=Captain America, profession=Soldier, age=70, canFly=false], SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=30, canFly=true]]
//        []
//
//        *** Optional empty() & orElseThrow() ***
//        ** Printing exception **
//        java.lang.RuntimeException: Empty String found
//        at com.demo.program.java8.OptionalDemo.lambda$orElseThrowOptional$14(OptionalDemo.java:221)
//        at java.util.Optional.orElseThrow(Optional.java:290)
//        at com.demo.program.java8.OptionalDemo.orElseThrowOptional(OptionalDemo.java:221)
//        at com.demo.program.java8.OptionalDemo.main(OptionalDemo.java:24)

