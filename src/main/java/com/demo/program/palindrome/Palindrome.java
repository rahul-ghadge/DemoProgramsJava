package com.demo.program.palindrome;

public class Palindrome {

	public static void main(String[] args) {

		new Palindrome().checkPalindrome("level");
		new Palindrome().checkPalindrome("test");
		new Palindrome().checkPalindromeStringBuffer("nitin");
		new Palindrome().checkPalindromeStringBuffer("jay");
		new Palindrome().checkPalindromeReverse("madam");
		new Palindrome().checkPalindromeReverse("sir");
		
	}
	
	public void checkPalindrome(String str) {
		int start = 0;
		int end = str.length() - 1;
		while (start <= end) {
			if (start == end)
				System.out.println(str + " is palindrome");
			
			if (str.charAt(start) != str.charAt(end)) {
				System.out.println(str + " is not palindrome");
				break;
			}			
			start++;
			end--;
		}
	}
	
	
	public void checkPalindromeStringBuffer(String str) {
		if (str.equals(new StringBuffer(str).reverse().toString()))
			System.out.println(str + " is palindrome");
		else
			System.out.println(str + " is not palindrome");
	}
	
	
	
	public void checkPalindromeReverse(String str) {
		
		StringBuilder rev = new StringBuilder();
		
		for (int i = str.length() -1 ; i >= 0 ; i--) {
			rev.append(str.charAt(i));
		}
		
		if (rev.toString().equals(str))
			System.out.println(str + " is palindrome");
		else
			System.out.println(str + " is not palindrome");
	}
}
