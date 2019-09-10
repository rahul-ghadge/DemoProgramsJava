package com.demo.program.singleton;

public class RestrictCloneInSingleton {

	public static void main(String[] args) {

		try {

			SingletonNew singleton = SingletonNew.getInstance();
			SingletonNew singleton2 = (SingletonNew) singleton.clone();
			
			System.out.println("Singleton 1 : " + singleton.hashCode());
			System.out.println("Singleton 2 : " + singleton2.hashCode());

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}

class SingletonNew implements Cloneable {

	private SingletonNew() {
	}

	private static final class SingletonPrivate {
		private static SingletonNew instance = new SingletonNew();
	}

	public static SingletonNew getInstance() {
		return SingletonPrivate.instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {

		// This will prevent from cloning object and will return same object
		return SingletonPrivate.instance;

		// This will return new object for clone() method
		// return super.clone();
	}
}
