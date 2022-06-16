package com.demo.program.leetcode.num;

public class Palindrome {

    public static void main(String[] args) {

        System.out.println("12321 is palindrome: " + isPalindrome(12321));
        System.out.println("1231 is palindrome: " + isPalindrome(1231));
    }

    static boolean isPalindrome(int num) {
        if (num < 0 || (num % 10 == 0 && num != 0))
            return false;

        int reverseNum = 0;

        while (num > reverseNum) {
            int pop = num % 10;
            reverseNum = reverseNum * 10 + pop;
            num /= 10;
        }
        return num == reverseNum || num == reverseNum / 10;
    }
}
