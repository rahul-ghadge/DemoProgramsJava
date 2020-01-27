package com.demo.program.map.operations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MaxRepeatativeLetter {

	public static void main(String[] args) {

		String str = "This is test programmmmmmm abcd";		
		System.out.println("Word : " + repeatativeCount(str));
		
		str = "No Word";
		System.out.println("Word : " +repeatativeCount(str));
	}

	
	@SuppressWarnings("rawtypes")
	public static String repeatativeCount(String myString) {

		int largestCount = 0;
		String largestCountWord = "";

		String[] wordsArr = myString.split("\\s+"); // myString.split(" ");

		for (int i = 0; i < wordsArr.length; i++) {

			String word = wordsArr[i];
			Map<String, Integer> map = new HashMap<>();

			for (int j = 0; j < word.length(); j++) {

				String ch = Character.toString(word.charAt(j));

				if (map.containsKey(ch)) {
					map.put(ch, map.get(ch) + 1);
				} else {
					map.put(ch, 1);
				}
			}

			Iterator it = map.values().iterator();
			while (it.hasNext()) {
				int currentCount = (int) it.next();
				
				if (currentCount > largestCount) {
					largestCount = currentCount;
					largestCountWord = word;
					
					// System.out.println("Count :: " + currentLargestCount);
					// System.out.println("Word :: " + currentBestWord);
				
				} else if (largestCount == 1) {
					largestCountWord = "-1";
				}
			}
		}
		return largestCountWord;
	}
}

// Output
// Word : programmmmmmm
// Word : -1


