package com.demo.program.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NPrimeNumber {

    @SuppressWarnings("resource")
	public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the limit : ");
        int n = in.nextInt();

        getNPrimeNumers(n);
    }



    public static void getNPrimeNumers(int n) {

        //boolean flag;

        List<Integer> arr = new ArrayList<>();

        for (int i = 2; arr.size() < n; i++) {
            boolean flag = true;

            if (!arr.isEmpty()) {
                int index = 0;
                for (int slct = arr.get(index++); slct <= i / 2; slct = arr.get(index++))

                    if (i % slct == 0) {
                        flag = false;
                        break;
                    }
            }

            if (flag) {
                arr.add(i);
                System.out.print("" + i + "\t");
            }
        }
    }
}
