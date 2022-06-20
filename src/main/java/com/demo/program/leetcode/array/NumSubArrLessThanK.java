package com.demo.program.leetcode.array;

public class NumSubArrLessThanK {
    public static void main(String[] args) {

        int[] arr = {10, 5, 2, 6};
        System.out.println(numSubArrCountLessThanK(arr, 100));
    }

    static int numSubArrCountLessThanK(int arr[], int k) {
        int count = 0;

        if (arr.length <= 0) return 0;

        for (int i = 0; i < arr.length; i++) {
            int prod = arr[i];
            if (prod < k)
                count++;

            for (int j = i + 1; j < arr.length && prod < k; j++) {
                prod *= arr[j];

                if (prod < k)
                    count++;
            }
        }

        return count;
    }
}
