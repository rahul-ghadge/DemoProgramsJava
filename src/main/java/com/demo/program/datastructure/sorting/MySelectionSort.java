package com.demo.program.datastructure.sorting;

import java.util.Arrays;

public class MySelectionSort {

    public static void doSelectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j])
                    index = j;
            }

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;


            System.out.println(Arrays.toString(arr));

        }
    }

    public static void main(String a[]) {

        int[] arr1 = {10, 34, 2, 56, 7, 67, 88, 42};
        doSelectionSort(arr1);
    }
}