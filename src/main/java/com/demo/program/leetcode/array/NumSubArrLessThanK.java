package com.demo.program.leetcode.array;

public class NumSubArrLessThanK {
    public static void main(String[] args) {

        int[] arr = {10, 5, 2, 6};
        System.out.println("\n\nFinal count: " + numSubArrCountLessThanK(arr, 100));
    }

    static int numSubArrCountLessThanK(int arr[], int k) {
        int count = 0;

        if (arr.length <= 0) return 0;

        for (int i = 0; i < arr.length; i++) {
            int prod = arr[i];
            if (prod < k) {
                count++;
                System.out.print("\n$Count: " + count); // This statement can be removed - it is only to print the value
            }


            for (int j = i + 1; j < arr.length && prod < k; j++) {
                System.out.print("  (" + prod + " * " + arr[j] + ")");
                prod *= arr[j];
                System.out.println(" => " + prod);

                if (prod < k) {
                    count++;
                    System.out.print("#Count: " + count); // This statement can be removed - it is only to print the value
                }
            }

            // Below if block can be removed - it is only to print the element
            if (prod < k)
                System.out.print("  " + arr[i]);

        }

        return count;
    }
}

//-----------------------------------------------------------------------------
//        Output
//-----------------------------------------------------------------------------
//
//        $Count: 1  (10 * 5) => 50
//        #Count: 2  (50 * 2) => 100
//
//        $Count: 3  (5 * 2) => 10
//        #Count: 4  (10 * 6) => 60
//        #Count: 5  5
//        $Count: 6  (2 * 6) => 12
//        #Count: 7  2
//        $Count: 8  6
//
//        Final count: 8