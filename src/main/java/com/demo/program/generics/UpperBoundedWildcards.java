package com.demo.program.generics;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class UpperBoundedWildcards {

    public static void main(String[] args) {

        System.out.println("**** Integers numbers ****");
        List<Integer> integers = Arrays.asList(10, 20, 30, 40, 50);
        numberWildcards(integers);

        System.out.println("**** Double numbers ****");
        List<Double> doubles = Arrays.asList(1.10, 2.20, 3.30, 4.40, 5.50);
        numberWildcards(doubles);


        System.out.println("**** Mixed Strings ****");
        List<Serializable> mixedStrings =
                Arrays.asList(
                        "Java Developer",
                        new StringBuilder("Fullstack developer"),
                        new StringBuffer("UI developer")
                );

        stringWildcards(mixedStrings);


        System.out.println("**** Plain Strings ****");
        List<String> strings = Arrays.asList("java", "Spring", "NoSQL");
        stringWildcards(strings);



        System.out.println("**** String Builder ****");
        List<StringBuilder> stringBuilders =
                Arrays.asList(
                        new StringBuilder("Docker"),
                        new StringBuilder("AWS"),
                        new StringBuilder("jenkins")
                );

        stringWildcards(stringBuilders);


    }

    public static void numberWildcards(List<? extends Number> list) {

        int max = list.stream()
                .map(Number::intValue)
                .max(Comparator.naturalOrder())
                .get();
        System.out.println("Max value from List :: " + max);

        double sum = 0.0;
        for (Number num: list) {
            sum += num.doubleValue();
        }
        System.out.println("Sum of List :: " + sum);
        System.out.println();
    }


    public static void stringWildcards(List<? extends Serializable> list) {
        list.forEach(str ->
                System.out.println(str + " length : " + str.toString().length()));
        System.out.println();
    }
}


//  ====================================================
//  Output ::
//  =====================================================
//
//    **** Integers numbers ****
//    Max value from List :: 50
//    Sum of List :: 150.0
//
//    **** Double numbers ****
//    Max value from List :: 5
//    Sum of List :: 16.5
//
//    **** Mixed Strings ****
//    Java Developer length : 14
//    Fullstack developer length : 19
//    UI developer length : 12
//
//    **** Plain Strings ****
//    java length : 4
//    Spring length : 6
//    NoSQL length : 5
//
//    **** String Builder ****
//    Docker length : 6
//    AWS length : 3
//    jenkins length : 7
