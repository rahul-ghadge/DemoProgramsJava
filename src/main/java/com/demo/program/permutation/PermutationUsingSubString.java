package com.demo.program.permutation;

public class PermutationUsingSubString {

    public static void main(String[] args) {

        permutation("", "amol");
    }


    private static void permutation(String perm, String word) {

        if (word.isEmpty()) {
            System.err.println(perm);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));

            }
        }
    }

}




