package com.demo.program.numbers;

import java.util.Arrays;
import java.util.List;

public class SumOfNumbers {

	public static void main(String[] args) {

		// sum of number from list
		// condition: skip all numbers between 6 and 9 including both numbers
		List<Integer> list = Arrays.asList(new Integer[] { 4, 5, 6, 7, 8, 9, 1, 10 });
		System.out.println("Sum of numbers(while loop) :: " + sumOfNumbersUsingWhile(list));

		List<Integer> list1 = Arrays.asList(new Integer[] { 4, 5, 6, 7, 6, 8, 12, 9, 10, 9, 11, 10 });
		System.out.println("Sum of numbers(while loop) :: " + sumOfNumbersUsingWhile(list1));

		List<Integer> list2 = Arrays.asList(new Integer[] { 9, 1, 6, 10 });
		System.out.println("Sum of numbers(using index) :: " + sumOfNumbersUsingIndexBreak(list2));

		List<Integer> list3 = Arrays
				.asList(new Integer[] { 9, 1, 6, 10, 9, 90 });
		System.out.println("Sum of numbers(using index) :: " + sumOfNumbersUsingIndexSize(list3));

	}

	public static int sumOfNumbersUsingWhile(List<Integer> numbers) {

		int sum = 0;
		boolean add = true;
		int lastNinesIndex = numbers.lastIndexOf(9);

		for (int i = 0; i < numbers.size(); i++) {

			int num = numbers.get(i);

			while (add) {
				// if num != 6 add to existing sum
				if (num != 6) {
					sum += num;
					break;
				} else {
					// set add false if num == 6
					add = false;
				}
			}

			while (!add) {
				// break while loop if num !=9
				if (num != 9) {
					break;
				} else {
					// set add false if num == last 9 from list
					if (i == lastNinesIndex) {
						add = true;
					}
					break;
				}
			}
		}
		return sum;
	}

	
	
	public static int sumOfNumbersUsingIndexBreak(List<Integer> numbers) {

		int sum = 0;
		int lastNinesIndex = numbers.lastIndexOf(9);

		for (int i = 0; i < numbers.size(); i++) {

			int num = numbers.get(i);

			if (num != 6) {
				sum += num;
			} else {
				if (lastNinesIndex > i) {
					i = lastNinesIndex;
				} else {
					// if last index of 9 not > i break the loop
					break;
				}
			}
		}
		return sum;
	}
	
	
	public static int sumOfNumbersUsingIndexSize(List<Integer> numbers) {
		int sum = 0;
		int lastNinesIndex = numbers.lastIndexOf(9);
		for (int i = 0; i < numbers.size(); i++) {
			int num = numbers.get(i);
			if (num != 6) {
				sum += num;
			} else {
				// if lastIndex > i then set currentIndex(i)=lastIndex else currentIndex(i)=lastElement 
				 i = lastNinesIndex > i ? lastNinesIndex : numbers.size();
			}
		}
		return sum;
	}

}
