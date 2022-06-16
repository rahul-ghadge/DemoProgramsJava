package com.demo.program.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfPair {

    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};
        int target = 9;
        String str = Stream.of(sumOfPair(arr,target))
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(str);
    }

    static Integer[] sumOfPair(int[] arr, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int computedValue = target - arr[i];

            if (indexMap.containsKey(computedValue)) {
                return new Integer[]{indexMap.get(computedValue), i};
            }
            indexMap.put(arr[i], i);
        }

        return null;
    }
}
