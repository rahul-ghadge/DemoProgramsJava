
import java.util.ArrayList;
import java.util.List;

public class FindMissingElementFromDuplicateList {

	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(9);
		list1.add(5);
		list1.add(7);
		list1.add(3);
		
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(9);
		list2.add(10);
		list2.add(5);
		list2.add(7);
		list2.add(3);
		
		
		TestLists testLists = new TestLists();
		int num = testLists.findMissingElementUsingContainsJava7(list1, list2);		
		System.out.println("Missing number(contains() java 7) : " + num);
		
		
		num = testLists.findMissingElementUsingContainsJava8(list1, list2);		
		System.out.println("Missing number(contains() java 8) : " + num);
		
		
		
		num = testLists.findMissingElementUsingSumJava7(list1, list2);		
		System.out.println("Missing number(sum() java 7) : " + num);
		
		
		num = testLists.findMissingElementUsingSumJava8(list1, list2);		
		System.out.println("Missing number(sum() java 8) : " + num);

	}

}

class TestLists {
	
	public int findMissingElementUsingContainsJava8(List<Integer> list1, List<Integer> list2) {
		
		if (list1.size() > list2.size()) 
			return list1.stream().filter(num -> !list2.contains(num)).findFirst().get();
		else 
			return list2.stream().filter(num -> !list1.contains(num)).findFirst().get();
	
	}
	
	
	public int findMissingElementUsingContainsJava7(List<Integer> list1, List<Integer> list2) {

		int missingNum = 0;

		if (list1.size() > list2.size()) {
			for (Integer num : list1) {
				if (!list2.contains(num))
					missingNum = num;
			}
		} else {
			for (Integer num : list2) {
				if (!list1.contains(num))
					missingNum = num;
			}
		}
		return missingNum;
	}
	
	
  
	
	public int findMissingElementUsingSumJava8(List<Integer> list1, List<Integer> list2) {

		int sum1 = list1.stream().mapToInt(num -> num).sum();
		int sum2 = list2.stream().mapToInt(num -> num).sum();

		if (sum1 > sum2)
			return sum1 - sum2;
		else
			return sum2 - sum1;

	}
	
	
	public int findMissingElementUsingSumJava7(List<Integer> list1, List<Integer> list2) {

		int sum1 = 0;
		int sum2 = 0;

		for (Integer num : list1) {
			sum1 += num;
		}

		for (Integer num : list2) {
			sum2 += num;
		}

		if (sum1 > sum2)
			return sum1 - sum2;
		else
			return sum2 - sum1;

	}
	
}
