package com.demo.program.leetcode.num;

public class XPowN {
    public static void main(String[] args) {

        System.out.println(xPOWn(2.0, 10));
        System.out.println(xPOWn(-2.0, 10));
        System.out.println(xPOWn(2.1000, 3));
    }

    static double xPOWn(double x, int n) {

        double ans = 1.0;
        int num = n;

        if (n < 0) {
            num *= -1;
        }

        while (num > 0) {
            if (num % 10 == 0) {
                x *= x;
                num /= 2;
            } else {
                ans *= x;
                num -= 1;
            }
            if (n < 0)
                return 1.0 / ans;
        }
        return ans;

    }
}
