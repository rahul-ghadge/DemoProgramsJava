package com.collection;

public class Product implements Comparable<Product>{

	private int productId;
	private String productName;
	private float price;
	public Product(int productId, String productName, float price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public float getPrice() {
		return price;
	}

	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", price=" + price + "]";
	}
	
	/*public int compareTo(Object obj)
	{
        Product p = (Product)obj;
		if(this.productId>(p.productId)){
			return 1;
		}
		else if(this.productId<p.productId){
			return -1;
		}
		return 0;*/
		
	public int compareTo(Product p)
	{
		return p.productId - this.productId;	
		//return this.productId - p.productId;	
	}
}
