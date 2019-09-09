package com.demo.copy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import test.com.demo.IkmTest;

public class DeepCopy {

	public static void main(String[] args) {

    // Create any test class with display method
		Test test = new Test();
		test.display();

		DeepCopy deepCopy = new DeepCopy();
		Test testCopy = (Test) deepCopy.getDeepCopyOfObject(test);
		testCopy.display();

		System.out.println(test.hashCode());
		System.out.println(testCopy.hashCode());
	}

	
	
	@SuppressWarnings("unchecked")
	public <T> T getDeepCopyOfObject(T object) {
		T t = null;
		if (object != null) {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(bos);
				oos.writeObject(object);
				oos.flush();
				ByteArrayInputStream bin = new ByteArrayInputStream(
						bos.toByteArray());
				ObjectInputStream ois = new ObjectInputStream(bin);

				t = (T) ois.readObject();

			} catch (IOException ioException) {
				ioException.printStackTrace();
			} catch (ClassNotFoundException classNotFoundEx) {
				classNotFoundEx.printStackTrace();
			}
		}
		return t;
	}

}
