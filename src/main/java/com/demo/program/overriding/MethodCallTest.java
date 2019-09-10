package com.demo.program.overriding;

public class MethodCallTest {

    public static void main(String[] args) {

        MethodCallTest m = new MethodCallTest();

        //m.print(null, "");
        m.stringObjTest(null);

    }


    public void stringObjTest(String str) {

        System.out.println("1 :: " + str);
    }


    public void stringObjTest(Object str) {

        System.out.println("2 :: " + str);
    }


    public void print(String str, Object obj) {
        System.out.println("1 :: " + str + " " + obj);
    }

    public void print(Object obj, String str) {
        System.out.println("2 :: " + str + " " + obj);
    }
}
