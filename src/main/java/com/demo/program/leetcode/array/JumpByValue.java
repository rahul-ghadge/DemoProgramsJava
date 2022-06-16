package com.demo.program.leetcode.array;

public class JumpByValue {
    public static void main(String[] args) {

        int[] arr = {2, 3, 1, 1, 4};
        System.out.println("Can Reach: " + canReachToEndByJump(arr));

        int[] arr1 = {3, 2, 1, 0, 4};
        System.out.println("Can Reach: " + canReachToEndByJump(arr1));

        System.out.println("---------------------------------");

        System.out.println("Can Reach: " + optimizedCanReachToEndByJump(arr));
        System.out.println("Can Reach: " + optimizedCanReachToEndByJump(arr1));


    }

    static boolean canReachToEndByJump(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            boolean canReach = false;

            for (int j = i - 1; j >= 0; j--) {
                if ((i - j) <= arr[j])
                    canReach = true;
            }
            if (!canReach) return false;
        }

        return true;
    }

    static boolean optimizedCanReachToEndByJump(int[] arr) {

        int step = 0;
        for (int i = 0; i < arr.length && i <= step; i++) {
            int jump = arr[i] + i;
            step = jump > step ? jump : step;

            if (step >= arr.length - 1)
                return true;
        }
        return false;
    }
}
