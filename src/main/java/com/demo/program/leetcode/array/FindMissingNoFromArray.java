package com.demo.program.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class FindMissingNoFromArray {
    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 4, 1};

        System.out.println(findMissing(arr));
    }


    static List<Integer> findMissing(int[] arr) {
        List<Integer> missing = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {

            int n = Math.abs(arr[i]);

            if (arr[n - 1] > 0)
                arr[n - 1] *= -1;

        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                missing.add(i + 1);
        }
        return missing;
    }
}
