package com.demo.program.ci;

import java.util.Arrays;

public class ShiftZerosToLeftRight {
    public static void main(String[] args) {
        int[] arr = {0, 4, 5, 2, 0, 0, 7, 2, 0, 1};

        moveZeroesToRight(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("----------------------------------------------------");

        moveZeroesToLeft(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZeroesToRight(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    System.out.println("i: " + nums[i] + " j: " + nums[j]);
                    if (nums[j] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    private static void moveZeroesToLeft(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                for (int j = i - 1; j >= 0; j--) {
                    System.out.println("i: " + nums[i] + " j: " + nums[j]);
                    if (nums[j] == 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }
}

//-----------------------------------------------------------------------------
//        Output
//-----------------------------------------------------------------------------
//        i: 0 j: 4
//        i: 0 j: 5
//        i: 0 j: 2
//        i: 0 j: 0
//        i: 0 j: 0
//        i: 0 j: 7
//        i: 0 j: 0
//        i: 0 j: 0
//        i: 0 j: 2
//        i: 0 j: 0
//        i: 0 j: 0
//        i: 0 j: 0
//        i: 0 j: 1
//        i: 0 j: 0
//        i: 0 j: 0
//        i: 0 j: 0
//        i: 0 j: 0
//        i: 0 j: 0
//        i: 0 j: 0
//        [4, 5, 2, 7, 2, 1, 0, 0, 0, 0]
//        ----------------------------------------------------
//        i: 1 j: 2
//        i: 1 j: 7
//        i: 1 j: 2
//        i: 1 j: 5
//        i: 1 j: 4
//        i: 2 j: 7
//        i: 2 j: 2
//        i: 2 j: 5
//        i: 2 j: 4
//        i: 7 j: 2
//        i: 7 j: 5
//        i: 7 j: 4
//        i: 2 j: 5
//        i: 2 j: 4
//        i: 5 j: 4
//        [4, 5, 2, 7, 2, 1, 0, 0, 0, 0]