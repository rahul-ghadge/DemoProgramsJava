package com.demo.program.generics;

import java.util.Arrays;
import java.util.List;

public class UnboundedWildcards {

    public static void main(String[] args) {

        System.out.println("**** List of Objects ****");
        List<Object> list = Arrays.asList("Core java", 100, new Exception("Not found"));

        print(list);
    }

    private static void print(List<?> list) {

        for (Object item: list) {
            if (item instanceof String)
                System.out.println("String : " + item);
            else if (item instanceof Number)
                System.out.println("Number : " + item);
            else
                System.out.println("Object : " + item);
        }

    }
}


//  ====================================================
//  Output ::
//  =====================================================
//    **** List of Objects ****
//    String : Core java
//    Number : 100
//    Object : java.lang.Exception: Not found
