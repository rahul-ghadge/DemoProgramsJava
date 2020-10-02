package Assignment;

public class Tablet extends Medicine {

	Tablet(String name, String address){
		super(name, address);
	}
	
	void displayLabel() 
	{
		System.out.println("Name : "+name);
		System.out.println("Address : "+address);
		System.out.println("Store in a cool place");
		
	}
	
}