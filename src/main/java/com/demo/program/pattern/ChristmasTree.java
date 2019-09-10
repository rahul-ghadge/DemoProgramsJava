package com.demo.program.pattern;

import java.util.Scanner;

public class ChristmasTree {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("How Many Rows You Want In Your Tree? -> ");

		int noOfRows = sc.nextInt();
		int rowCount = 1;
		System.out.println("** Here Is Your Christmas Tree **");

		loop: for (int i = noOfRows; i > 0;) {			
				for (int j = 1; j < i; j++) {
					System.out.print(" ");
				}
				for (int j = 1; j <= rowCount; j++) {
					if (j == rowCount) {
						System.out.println(" A");
						break loop;
					}
				}
			}

		
		for (int i = noOfRows; i > 0; i--) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= rowCount; j++) {

				if (j == 1) {
					if (j == rowCount)
						System.out.print("/*\\");
					else 
						System.out.print("/* ");
				} else {
					if (j == rowCount)
						System.out.print("*\\");
					else
						System.out.print("* ");
				}
			}

			System.out.println();
			rowCount++;
		}

		for (int i = 0; i < noOfRows; i++) {
			if (i == 0)
				System.out.print("~");
			System.out.print("~~");
		}
		
		
		System.out.println();
		
		
		for (int i = noOfRows; i > 1;) {
			int rootEle = noOfRows / 5;

			for (int j = 0; j < noOfRows - 1; j++) {
				for (int l = 1; l < i; l++) {
					System.out.print(" ");
				}
				
				System.out.print("|");
				for (int m = 0; m < rootEle; m++) {
					System.out.print(" ");
				}
				System.out.println("|");
			}
			break;
		}
	}
}


// Output
//How Many Rows You Want In Your Tree? -> 7
//** Here Is Your Christmas Tree **
//       A
//      /*\
//     /* *\
//    /* * *\
//   /* * * *\
//  /* * * * *\
// /* * * * * *\
///* * * * * * *\
//~~~~~~~~~~~~~~~
//      | |
//      | |
//      | |
//      | |
//      | |
//      | |
