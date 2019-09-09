package com.demo.programs.finaly;

import java.util.ArrayList;
import java.util.List;

public class FinallyBlock {

	public static void main(String[] args) {

		List<Integer> listOne = new ArrayList<>();
		listOne.add(5);
		listOne.add(20);
		listOne.add(15);
		listOne.add(10);

		System.out.println(FinallyChild.testFinally(listOne));

	}

}

class FinallyChild {

	public static int testFinally(List<Integer> list) {

		try {
			int sum = 0;

			for (Integer integer : list) {
				integer /= 0;
				sum += integer;
			}

			return sum;
		} catch (Exception e) {
			System.out.println("Error");
			return 0;
		} finally {
			System.out.println("Inside finally block...!");
		}

	}

}
