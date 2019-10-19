package com.demo.program.reccursion;

public class BiggestInArray {

	static int highest = Integer.MIN_VALUE;
	
	public static void main(String[] args) {

		int arr[] = { 1, 3, 6, 2, 5, 10, 55, 4, 7 };
		
		int biggest = findBiggest(arr, arr.length - 1);
		System.out.println("Max : " + biggest);

	}

	public static int findBiggest(int[] arr, int num) {

		if (num == -1) {
			return highest;
		} else if (arr[num] > highest) {
			highest = arr[num];
		}
		return findBiggest(arr, num - 1);
	}

}
