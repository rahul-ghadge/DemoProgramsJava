package com.collection;

import java.util.Comparator;

public class ProductCompare implements Comparator<Product>{
	
	/*public int compare(Object obj1, Object obj2) {
		
		Product p1 = (Product)obj1;
		Product p2 = (Product)obj2;
		return p1.getProductName().compareTo(p2.getProductName());
	}
*/
	public int compare(Product obj1, Product obj2) {
	return obj1.getProductName().compareTo(obj2.getProductName());
} 
}
