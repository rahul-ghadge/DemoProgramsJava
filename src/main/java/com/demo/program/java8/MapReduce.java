package com.demo.program.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduce {

	public static void main(String[] args) {

		/*
		 * Return string which is having most string length
		 */
		List<String> words = Arrays.asList("first string", "second sting",
				"test string", "another test string", "Combination of all above string");

		Optional<String> longestString = words.stream().reduce(
				(word1, word2) -> word1.length() > word2.length() ? word1
						: word2);
		longestString.ifPresent(System.out::println);

		/*
		 * Calculate sum of numbers from array
		 */
		List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);
		int sum = array.stream().reduce(0,
				(element1, element2) -> element1 + element2);
		System.out.println("The sum of all elements is " + sum);
	}
}
