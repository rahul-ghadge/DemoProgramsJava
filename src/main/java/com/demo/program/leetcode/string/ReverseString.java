package com.demo.program.leetcode.string;

public class ReverseString {
    public static void main(String[] args) {

        System.out.println("Hello World : " + reverseString("Hello World"));
    }

    static String reverseString(String str) {

        char[] strArr = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            char temp = strArr[left];
            strArr[left] = strArr[right];
            strArr[right] = temp;

            left++;
            right--;
        }
        return new String(strArr);
    }
}
