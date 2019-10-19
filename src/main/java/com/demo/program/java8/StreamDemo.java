package com.demo.program.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 4,
				8, 9, 7 });

		Stream<Integer> intStram = Stream.of(1, 2, 3, 4, 5, 5, 6, 6, 7);
		// Concat stream with another stream
		Stream<Integer> stream = Stream.concat(list.stream(), intStram);// .distinct();

		
		// Sort list in natural order
		list.stream().sorted().forEach(System.out::println);
		
		
		System.out.println("-----------------");
		// First distict from list then sort in reverse order
		list.stream().distinct().sorted(Collections.reverseOrder())
				.forEach(System.out::println);
		
		
		System.out.println("-----------------");		
		// First distinct then calculate square of each element
		stream.distinct().map(n -> n * n).forEach(System.out::println);

		
		System.out.println("-----------------");
		// Collect all squares in set(unique elements)
		Set<Integer> squareSet = list.stream().map(x -> x * x)
				.collect(Collectors.toSet());
		System.out.println(squareSet);
		
		
		System.out.println("-----------------");
		// print all even numbers
		list.stream().filter(x->x%2==0).forEach(System.out::println);
		
		
		System.out.println("-----------------");
		// calculate sum of distict numbers using reduce
		int addition = list.stream().distinct().reduce(0,(sum,i)-> sum+i);
		System.out.println("Sum : " + addition);
		
		
		System.out.println("-----------------");
		// count distict element
		long count = list.stream().distinct().count();
		System.out.println("Count : "  + count);
		
		
		System.out.println("-----------------");
		// Max from distict element
		Optional<Integer> max = list.stream().distinct().max(Comparator.naturalOrder());
		System.out.println("Max : "  + max.get());
		
		
		System.out.println("-----------------");
		// Min from distict element
		Optional<Integer> min = list.stream().distinct().min(Comparator.naturalOrder());
		System.out.print("Min : ");
		min.ifPresent(System.out::println);

	}
}
