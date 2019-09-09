
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIterations {

	public static void main(String[] args) {

		Map<Integer, String> customers = new HashMap<>();
		customers.put(1, "Rohit");
		customers.put(2, "Rajesh");
		customers.put(3, "Rahul");
		customers.put(4, "Rajan");


		// JAVA 7: Using EntrySet(Map.Entry)
		for (Map.Entry<Integer, String> entry : customers.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " value : " + entry.getValue());
		}
		
		// JAVA 7: Using KeySet
		for (Integer key : customers.keySet()) {
		      System.out.println("Key : " + key + " value : " + customers.get(key));
		    }
		
		// JAVA 7: Using while, EntrySet and Iterator interface
		Iterator<Map.Entry<Integer, String>> iterator = customers.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = iterator.next();
			System.out.println("Key : " + entry.getKey() + " value : " + entry.getValue());
		}
		
		// JAVA 7: Using while KeySet and Iterator interface
		Iterator<Integer> keysIterator = customers.keySet().iterator();
		while (keysIterator.hasNext()) {
			Integer key = keysIterator.next();
			System.out.println("Key : " + key + " value : " + customers.get(key));
		}
		
		// JAVA 8: Using forEach method
		customers.forEach((key, value) -> {
			System.out.println("Key : " + key + " value : " + value);
		});
		
		
		// JAVA 8: Using entrySet, stream and forEach method
		customers.entrySet().stream().forEach(entry ->
		System.out.println("Key : " + entry.getKey() + " value : " + entry.getValue()));

	}

}
