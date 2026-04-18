package com.demo.program.singleton;

import java.lang.reflect.Constructor;

public class RestrictReflectionInSingleton {

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {

        SingletonStatic singleton = SingletonStatic.instance;
        SingletonStatic singleton2 = null;


        try {
            Constructor[] constructors = SingletonStatic.class
                    .getDeclaredConstructors();

            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                singleton2 = (SingletonStatic) constructor.newInstance();
                break;
            }

            System.out.println("Singleton 1 : " + singleton.hashCode());
            System.out.println("Singleton 2 : " + singleton2.hashCode());


            // cannot break that using reflection
            RestrictReflection restictReflection = RestrictReflection.instance;
            RestrictReflection restictReflection2 = null;

            Constructor[] newConstructors = RestrictReflection.class
                    .getDeclaredConstructors();

            for (Constructor constructor : newConstructors) {
                constructor.setAccessible(true);
                restictReflection2 = (RestrictReflection) constructor.newInstance();
                break;
            }

            System.out.println("RestrictReflection 1 : " + restictReflection.hashCode());
            System.out.println("RestrictReflection 2 : " + restictReflection2.hashCode());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Singleton class
class SingletonStatic {
    // public static instance initialized when loading the class
    public static SingletonStatic instance = new SingletonStatic();

    // private constructor
    private SingletonStatic() {
    }
}

// to overcome reflection use enum
enum RestrictReflection {
    instance;
}


//
//        Singleton 1 : 460141958
//        Singleton 2 : 1163157884
//        java.lang.IllegalArgumentException: Cannot reflectively create enum objects
//	        at java.lang.reflect.Constructor.newInstance(Constructor.java:417)
//          at com.demo.program.singleton.RestrictReflectionInSingleton.main(RestrictReflectionInSingleton.java:38)
//
//        Process finished with exit code 0
