package com.demo.program.leetcode.array;

import java.util.Arrays;

public class MoveZerosAtEnd {

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 3, 0, 12};

        moveZerosWithPreservingTheOrder(arr);

        System.out.println(Arrays.toString(arr));

//        for (int n : arr) {
//            System.out.println(n);
//        }

    }

    static void moveZerosWithPreservingTheOrder(int[] arr) {
        int currentZero = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[currentZero] = arr[i];
                arr[i] = 0;
                currentZero++;
            }
        }
    }
}

//-----------------------------------------------------------------------------
//        Output
//-----------------------------------------------------------------------------
//        [1, 3, 12, 0, 0, 0]
