package com.demo.program.map.operations;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountCharsAndPrintInOrder {

	public static void main(String[] args) {
		
		
		String str = "abcabcbbbbbbaaccc";
		
		Map<Character, Integer> map = new HashMap<>();
		
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}			
		}
		
		map
		.entrySet()
		.stream()
		.sorted((v1, v2) -> v2.getValue() - v1.getValue()) // for decending order by values
		//.sorted((v1, v2) -> v1.getValue() - v1.getValue()) // for ascending order by values
		//.sorted(Map.Entry.comparingByValue()) // for ascending order by values
		.collect(
				Collectors.toMap(Map.Entry::getKey,
						Map.Entry::getValue,
						(oldValue, newValue) -> oldValue,
						LinkedHashMap::new))
		.forEach((k, v) -> {
			for(int i = 0; i < v; i++){
				System.out.print(k);
			}
		});
	}
}


// Output
// bbbbbbbbcccccaaaa
