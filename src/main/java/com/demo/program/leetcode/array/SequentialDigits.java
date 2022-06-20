package com.demo.program.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {

        System.out.println(getSequence(100, 300));
        System.out.println(getSequence(1000, 30000));

    }

    static List<Integer> getSequence(int low, int high) {
        List<Integer> sequences = new ArrayList<>();
        String digits = "123456789";

        for (int i = (low + "").length(); i <= 9; i++) {
            for (int j = 0; j < digits.length() && (j + i) <= digits.length(); j++) {
                int subStr = Integer.parseInt(digits.substring(j, j + i));
                if (subStr >= low && subStr <= high)
                    sequences.add(subStr);
            }
        }

        return sequences;

    }
}
