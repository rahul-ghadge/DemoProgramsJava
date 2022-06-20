package com.demo.program.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindKDifferenceCount {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 2, 4, 6};

        System.out.println(getKDifferenceCount(arr, 2));
        System.out.println(getKDifferenceCount(arr, 0));

    }

    static List<String> getKDifferenceCount(int arr[], int k) {

        Map<Integer, Integer> map = new HashMap<>();
        List<String> count = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        map.keySet()
                .stream()
                .forEach(num -> {
                    if (k == 0) {
                        if (map.get(num) == 2) {
                            count.add("[" + num + ", " + num + "]");
                        }
                    } else {
                        if (map.containsKey(num + k)) {
                            count.add("[" + num + ", " + (num + k) + "]");
                        }
                    }
                });
        return count;
    }
}
