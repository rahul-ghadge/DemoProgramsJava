package com.demo.program.comparatr;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class HashMapSorting {
	public static void main(String args[]) throws ParseException {

		// Create a map with Java releases and their code names
		Map<String, String> codenames = new HashMap<>();
		codenames.put("18", "Virat");
		codenames.put("10", "Messi");
		codenames.put("07", "Ronaldo");
		codenames.put("12", "Nemar");
		codenames.put("15", "Salah");
		codenames.put("11", "Sunil");
		codenames.put("27", "Ajinkya");
		

		System.out.println("\n\n(Java 7) HashMap before sorting, random order ");
		for (Entry<String, String> entry : codenames.entrySet()) {
			System.out.println(entry.getKey() + " ==> " + entry.getValue());
		}

		// *** 1: (Java 7) Sort by using keys(default way) ****
		// TreeMap keeps all entries in sorted order(sort by keys)
		Map<String, String> sortedTreemap = new TreeMap<>(codenames);

		System.out.println("\n\n(Java 7) HashMap after sorting by keys in ascending order \n");
		for (Entry<String, String> mapping : sortedTreemap.entrySet()) {
			System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
		}
		// ****************************************************
		
		// *** 2: (Java 7) Sort by using keys(default way) ****
		// TreeMap keeps all entries in sorted order(sort by keys)
		System.out.println("\n\n(Java 8) HashMap after sorting by keys in ascending order \n");
		codenames
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(
						Collectors.toMap(Map.Entry::getKey,
								Map.Entry::getValue,
								(oldValue, newValue) -> oldValue,
								LinkedHashMap::new))
				.forEach((k, v) -> System.out.println(k + " : " + v));
				// ****************************************************
				
				
		// *** 2: Sort by using values(Java 7) ****
		System.out.println("\n\n(Java 7) HashMap after sorting entries by values \n");
		sortMapUsingValuesJava7(codenames);
		// ****************************************************

		// *** 3: Sort by using values(Java 8) ****
		System.out.println("\n\n1: (Java 8) HashMap after sorting entries by values \n");
		sortMapUsingValuesJava8(codenames);
		// ****************************************************

	}

	private static void sortMapUsingValuesJava7(Map<String, String> map) {

		// Sort method needs a List, so let's first convert Set to List in Java
		List<Entry<String, String>> entries = new ArrayList<>(map.entrySet());
		// sorting HashMap by values using comparator
		Collections.sort(entries, new Comparator<Entry<String, String>>() {
			@Override
			public int compare(Entry<String, String> e1, Entry<String, String> e2) {
				String v1 = e1.getValue();
				String v2 = e2.getValue();

				return v1.compareTo(v2);
			}
		});
		// printing key values from entries
		for (Entry<String, String> entry : entries) {
			System.out.println(entry.getKey() + " ==> " + entry.getValue());
		}
		
	}

	private static void sortMapUsingValuesJava8(Map<String, String> map) {
		
		// Sort method needs a List, so let's first convert Set to List in Java
		List<Entry<String, String>> entries = new ArrayList<>(map.entrySet());

		
		// sorting HashMap by values using comparator
		Collections.sort(entries,
				(e1, e2) -> e1.getValue().compareTo(e2.getValue()));

		
		// (Java 8) Collecting keys and values for Map from sorted entries
		entries.stream().collect(
				Collectors.toMap(entry -> entry.getKey(),
						entry -> entry.getValue()));

		
		// (Java 8) printing key value pair
		entries.stream().forEach(
				entry -> System.out.println(entry.getKey() + " ==> "
						+ entry.getValue()));
	
		System.out.println("\n\n2: (Java 8) HashMap after sorting entries by values \n");		
		// (Java 8) Collecting keys and values and printing them 
		entries.stream()
				.collect(
						Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
								(e1, e2) -> e2, LinkedHashMap::new))
				.forEach((k, v) -> System.out.println(k + " : " + v));

	}
}


