package com.demo.program.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class AnagramString {
    public static void main(String[] args) {

        System.out.println(isAnagram("abc", "bac"));
        System.out.println(isAnagram("abc1", "bac2"));
        System.out.println(isAnagram("abccb", "bacab"));

    }

    static boolean isAnagram(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {

            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
            map.put(str2.charAt(i), map.getOrDefault(str2.charAt(i), 0) - 1);


//            if (map.containsKey(str1.charAt(i)))
//                map.put(str1.charAt(i), map.get(str1.charAt(i)) + 1);
//            else
//                map.put(str1.charAt(i), 1);
//
//            if (map.containsKey(str2.charAt(i)))
//                map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);
//            else
//                map.put(str2.charAt(i), -1);

        }

        return !map.values().stream().anyMatch(num -> num != 0);

    }
}
