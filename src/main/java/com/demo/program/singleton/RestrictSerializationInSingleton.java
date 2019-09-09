package com.demo.singleton;

import java.io.Serializable;

import test.com.demo.copy.DeepCopy;

public class RestrictSerializationInSingleton {

	public static void main(String[] args) {

		Singleton singleton = Singleton.getInstance();
		
		DeepCopy deepCopy = new DeepCopy();
		Singleton singleton1 = deepCopy.getDeepCopyOfObject(singleton);
		
		System.out.println("Singleton 1 : " + singleton.hashCode());
		System.out.println("Singleton 2 : " + singleton1.hashCode());
		
	}

}


class Singleton implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Singleton INSTANCE = null;
    
	private Singleton() {}
    
	public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
	
	// This will prevent serialization and deserialization
	protected Object readResolve(){
		return INSTANCE;
	}
}
