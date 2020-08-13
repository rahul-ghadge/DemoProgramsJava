package com.demo.program.generics;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class LowerBoundedWildcards {

    public static void main(String[] args) {

        System.out.println("**** Mixed Strings ****");
        List<Serializable> mixedStrings =
                Arrays.asList(
                        "Java Developer",
                        new StringBuilder("Fullstack developer"),
                        new StringBuffer("UI developer")
                );

        print(mixedStrings);


        System.out.println("**** Integer numbers ****");
        List<Integer> integers = Arrays.asList(10, 20, 30, 40, 50);
        numberWildcards(integers);

        System.out.println("**** Numbers ****");
        List<Number> numbers = Arrays.asList(10, 20, 30, 40, 50);
        numberWildcards(numbers);


        System.out.println("**** Double numbers ****");
        List<Double> doubles = Arrays.asList(1.10, 2.20, 3.30, 4.40, 5.50);
        // **** Compile time error here ****
        //numberWildcards(doubles);
        System.out.println("Compile time error here");
        System.out.println(doubles);
    }

    private static void print(List<? super Serializable> list) {
        list.forEach(str ->
                System.out.println(str + " length : " + str.toString().length()));
        System.out.println();
    }


    private static void numberWildcards(List<? super Integer> list) {

        int sum = 0;
        for (Object num: list) {
            sum += (Integer) num;
        }
        System.out.println("Sum of List :: " + sum);
        System.out.println();
    }
}



//  ====================================================
//  Output ::
//  =====================================================
//    **** Mixed Strings ****
//    Java Developer length : 14
//    Fullstack developer length : 19
//    UI developer length : 12
//
//    **** Integer numbers ****
//    Sum of List :: 150
//
//    **** Numbers ****
//    Sum of List :: 150
//
//    **** Double numbers ****
//    Compile time error here
//    [1.1, 2.2, 3.3, 4.4, 5.5]