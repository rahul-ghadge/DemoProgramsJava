package com.demo.program.datastructure.sorting;

import java.util.Arrays;

public class MyBubbleSort {

    public static void bubble_srt(int array[]) {
        int n = array.length;

        for (int m = 0; m <= n; m++) {

            //int count = 0;

            for (int i = 0; i < n - 1; i++) {

                if (array[i] > array[i + 1]) {
                    //count++;
                    swapNumbers(i, i + 1, array);
                }
            }

            //if (count == 0)
            //    break;

            printNumbers(array);

        }
    }


    private static void swapNumbers(int i, int j, int[] array) {

        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    private static void printNumbers(int[] input) {


        System.out.println(Arrays.toString(input));

        /*for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println("\n");*/
    }


    public static void main(String[] args) {
        int[] input = {4, 2, 9, 6, 23, 12, 34, 0, 1};
        bubble_srt(input);

    }
}