package com.demo.program.leetcode.array;

public class Merge2SortedArrays {
    public static void main(String[] args) {

        int[] arr1 = new int[6];
        arr1[0] = 1;
        arr1[1] = 3;
        arr1[2] = 5;
        int numberOfEleInArr1 = 3;

        int[] arr2 = {2, 8, 10};
        int numberOfEleInArr2 = 3;

        mergeArrays(arr1, numberOfEleInArr1, arr2, numberOfEleInArr2);

        for (int num :
                arr1) {
            System.out.println(num + " ");
        }
    }

    static void mergeArrays(int[] arr1, int p, int arr2[], int m) {

        p = p - 1;
        m = m - 1;

        for (int i = arr1.length - 1; i >= 0; i--) {
            int ele1 = p >= 0 ? arr1[p] : 0;
            int ele2 = m >= 0 ? arr2[m] : 0;

            if (ele1 >= ele2) {
                arr1[i] = ele1;
                p--;
            } else {
                arr1[i] = ele2;
                m--;
            }
        }

    }
}
