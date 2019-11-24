package com.demo.program.combination;

public class StringCombinations {
	
	private StringBuilder output = new StringBuilder();
	private final String inputstring;
	private static int counter = 0;

	
	public StringCombinations(final String str) {
		inputstring = str;
		System.out.println("The input string  is  : " + inputstring);
	}

	
	public static void main(String args[]) {
		StringCombinations combobj = new StringCombinations("rahul");
		System.out.println("");
		System.out.println("All possible combinations are :  ");
		System.out.println("");
		combobj.combine();
		System.out.println("");
		System.out.println("Total combinations :: " + counter);
	}

	
	public void combine() {
		combine(0);
	}

	
	private void combine(int start) {
		
		for (int i = start; i < inputstring.length(); ++i) {
		
			output.append(inputstring.charAt(i));
			System.out.println(output);
			counter++;
			
			if (i < inputstring.length())
				combine(i + 1);
			
			output.setLength(output.length() - 1);
		}
	}
}
