package com.demo.program.list.operations;

import java.util.Arrays;

public class RemoveDuplicateFromList {
    
	static void removeDuplicates(int[] arrayWithDuplicates) {
        
		System.out.println("Array With Duplicates :");
        System.out.println(Arrays.toString(arrayWithDuplicates));


        //Assuming all elements in input array are unique
        int n = arrayWithDuplicates.length;


        //Comparing each element with all other elements
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                //If any two elements are found equal
                if (arrayWithDuplicates[i] == arrayWithDuplicates[j]) {

                    //Replace duplicate element with last unique element
                    arrayWithDuplicates[j] = arrayWithDuplicates[n - 1];

                    //Decrementing noOfUniqueElements
                    n--;

                    //Decrementing j
                    j--;
                }
            }
        }

        //Copying only unique elements of arrayWithDuplicates into arrayWithoutDuplicates
        int[] arrayWithoutDuplicates = Arrays.copyOf(arrayWithDuplicates, n);


        //Printing arrayWithoutDuplicates
        System.out.println(": " + Arrays.toString(arrayWithoutDuplicates));

    }

	public static void main(String[] args) {

		removeDuplicates(new int[] { 4, 3, 2, 4, 9, 2 });

		removeDuplicates(new int[] { 1, 2, 1, 2, 1, 2 });

		removeDuplicates(new int[] { 15, 21, 11, 21, 51, 21, 11 });

		removeDuplicates(new int[] { 7, 3, 21, 7, 34, 18, 3, 21 });
	}
}