package com.demo.program.permutation;

// Java program to print all permutations of a
// given string.
public class Permutation {
    public static void main(String[] args) {
        String str = "ABC";
        int n = str.length();

        Permutation permutation = new Permutation();

        permutation.permute(str, 0, n - 1);

    }


    private void permute(String str, int current, int length) {

        if (current == length)
            System.out.println(str);
        else {
            for (int i = current; i <= length; i++) {
                str = swap(str, current, i);
                permute(str, current + 1, length);
                str = swap(str, current, i);
            }
        }
    }

    public String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();

        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;

        //char temp1 = charArray[i];
        return String.valueOf(charArray);
    }

}

