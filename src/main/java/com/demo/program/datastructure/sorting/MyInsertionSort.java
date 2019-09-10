package com.demo.program.datastructure.sorting;

import java.util.Arrays;

public class MyInsertionSort {

    public static void main(String a[]) {
        doInsertionSort(new int[]{10, 34, 2, 56, 7, 67, 88, 42});
    }

    public static void doInsertionSort(int[] input) {


        for (int i = 1; i < input.length; i++) {

            for (int j = i; j > 0; j--) {

                if (input[j - 1] > input[j]) {
                    int temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;

                }
           }

            System.out.println(Arrays.toString(input));
        }
    }

}
