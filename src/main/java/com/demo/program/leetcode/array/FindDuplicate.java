package com.demo.program.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicate {
    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 5, 4, 5};

        System.out.println(findDuplicate(arr));

    }

    static List<Integer> findDuplicate(int[] arr) {
        List<Integer> duplicate = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int num = Math.abs(arr[i]);

            if (arr[num - 1] < 0)
                duplicate.add(arr[i]);
            else
                arr[num - 1] *= -1;
        }
        return duplicate;
    }
}
