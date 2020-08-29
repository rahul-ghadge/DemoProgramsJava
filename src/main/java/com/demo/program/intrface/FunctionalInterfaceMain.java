package com.demo.program.intrface;

import java.util.ArrayList;
import java.util.List;

public class FunctionalInterfaceMain {

	public static void main(String[] args) {

		List<String> names = new ArrayList<>();
		names.add("RoHit");
		names.add("jay");
		names.add("sam");
		names.add("saLLy");
		names.add("josH");
		names.add("jose");
		names.add("jonh");


		CapitalizeName capitalizeName = (s) -> s.substring(0,1).toUpperCase()
				+ s.substring(1).toLowerCase();

		for (String name : names) {
			System.out.println(capitalizeName.capitalize(name));
		}
	}
}

@FunctionalInterface
interface CapitalizeName {
	String capitalize(String name);
}
