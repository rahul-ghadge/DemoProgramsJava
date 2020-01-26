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
		
		int currentLargestCount = 0;
		String currentBestWord = "";
		
		Map<String, Integer> characterCount = new HashMap<String, Integer>();
		String[] words = myString.split("\\s+");
		
		for (int i = 0; i < words.length; i++) {
			
			String word = words[i];
			characterCount = new HashMap<String, Integer>();
			
			for (int j = 0; j < word.length(); j++) {
				
				String character = Character.toString(word.charAt(j));
				
				if (characterCount.containsKey(character)) {
					characterCount.put(character, characterCount.get(character) + 1);
				} else {
					characterCount.put(character, 1);
				}
			}
			
			
			Iterator ir = characterCount.values().iterator();
			int thiscount = 0;
			while (ir.hasNext()) {
				int thischaractercount = (int) ir.next();
				
				if (thiscount < thischaractercount)
					thiscount = thischaractercount;
				
			}
			if (thiscount > currentLargestCount) {
				currentLargestCount = thiscount;
				currentBestWord = word;
				
				//System.out.println("Count :: " + currentLargestCount);
				//System.out.println("Word :: " + currentBestWord);

			} else if (currentLargestCount == 1) {
				currentBestWord = "-1";
			}			
		}
		return currentBestWord;		
	}
}

// Output
// Word : programmmmmmm
// Word : -1


