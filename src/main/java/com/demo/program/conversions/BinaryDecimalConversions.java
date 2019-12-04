package com.demo.program.conversions;

import java.util.ArrayList;
import java.util.List;

public class BinaryDecimalConversions {

	public static void main(String[] args) {
		toDecimalParseInt("1010");
		toDecimalCustom("1010");

		toDecimalCustom("abc");
		
		DecimalToBinaryParseInt(50);
		decimalToBinaryCustom(50);
	}

	// convert Binary to Decimal using Integers in-built method
	private static void toDecimalParseInt(String binaryNum) {
		System.out.println(binaryNum + "'s binary value : "
				+ Integer.parseInt(binaryNum, 2));
	}

	
	// convert Binary to Decimal using custom logic
	private static void toDecimalCustom(String binaryNum) {

		int decimal = 0;
		int num;

		try {
			num = Integer.parseInt(binaryNum);
		} catch (NumberFormatException e) {
			System.out.println("Please provide Binary Number");
			return;
		}

		for (int i = 0; num != 0; i++) {
			int temp = num % 10;
			decimal += temp * Math.pow(2, i);
			num /= 10;
		}

		System.out.println("--> " + binaryNum + "'s decimal value : " + decimal);
	}
	
	
	// convert Decimal to Binary using Integers in-built method
	private static void DecimalToBinaryParseInt(int decimalNum) {
		System.out.println(decimalNum + "'s binary value : "
				+ Integer.toBinaryString(decimalNum));
	}
	
	
	// convert Decimal to Binary using custom logic
	private static void decimalToBinaryCustom(int decimalNum) {

		List<Integer> list = new ArrayList<>();
		
		while(decimalNum > 0) {
			list.add(0, decimalNum % 2);
			decimalNum /=2;
		}
		
		System.out.print("Binary value : ");
		for (Integer bit : list) {
			System.out.print(bit);
		}
		
	}
}

// Output 
// -----------------------
//1010's binary value : 10
//1010's decimal value : 10
//Please provide Binary Number
//50's binary value : 110010
//Binary value : 110010
