package com.demo.program.palindrome;

public class Palindrome {

	public static void main(String[] args) {

		new Palindrome().checkPalindrom("level");
		new Palindrome().checkPalindrom("test");
		new Palindrome().checkPalindromStringBuffer("nitin");
		new Palindrome().checkPalindromStringBuffer("jay");
		new Palindrome().checkPalindromReverse("madam");
		new Palindrome().checkPalindromReverse("sir");
		
	}
	
	public void checkPalindrom(String str) {
		int start = 0;
		int end = str.length() - 1;
		while (start <= end) {
			if (start == end)
				System.out.println(str + " is palindrom");
			
			if (str.charAt(start) != str.charAt(end)) {
				System.out.println(str + " is not palindrom");
				break;
			}			
			start++;
			end--;
		}
	}
	
	
	public void checkPalindromStringBuffer(String str) {
		if (str.equals(new StringBuffer(str).reverse().toString()))
			System.out.println(str + " is palindrom");
		else
			System.out.println(str + " is not palindrom");
	}
	
	
	
	public void checkPalindromReverse(String str) {
		
		String rev = "";
		
		for (int i = str.length() -1 ; i >= 0 ; i--) {
			rev += str.charAt(i);			
		}
		
		if (rev.equals(str)) 
			System.out.println(str + " is palindrom");
		else
			System.out.println(str + " is not palindrom");
	}
}
