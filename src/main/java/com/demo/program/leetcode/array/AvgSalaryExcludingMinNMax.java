package com.demo.program.leetcode.array;

public class AvgSalaryExcludingMinNMax {
    public static void main(String[] args) {

        int[] arr = {4000, 3000, 1000, 2000};

        System.out.println(sumSalary(arr));
    }

    static long sumSalary(int[] arr) {

        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;

        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];

            sum += arr[i];
        }

        return (sum - (max + min)) / (arr.length - 2);

    }
}
