package com.demo.singleton;

import java.lang.reflect.Constructor;

public class RestrictReflectionInSingleton {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		SingletonStatic singleton = SingletonStatic.instance;
		SingletonStatic singleton2 = null;

		// cannot break that using reflection
		// RestictReflection restictReflection = RestictReflection.instance;

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
enum RestictReflection {
	instance;
}
