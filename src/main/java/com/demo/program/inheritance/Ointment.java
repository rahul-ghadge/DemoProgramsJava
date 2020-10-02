package Assignment;

public class Ointment extends Medicine {

	Ointment(String name, String address){
		super(name, address);
	}
	
	void displayLabel() 
	{
		System.out.println("Name : "+name);
		System.out.println("Address : "+address);
		System.out.println("For external use only..");
		
	}
	
}
