package Assignment;

public class Syrup extends Medicine
{
	Syrup(String name, String address){
		super(name, address);
	}
	
	void displayLabel() 
	{
		System.out.println("Name : "+name);
		System.out.println("Address : "+address);
		System.out.println("Consume as per doctor prescribes");	
	}
}
