package exceptionhandling;

import javax.activity.InvalidActivityException;

public class Contact {
	
	String firstName, middleName, lastName, dateOfBirth, anniversary, address, area, city, state, country;
	int pincode;
	char gender;
	String mobileNo, telePhoneNo, email, website;
	
	public Contact() {
		
	}
	
	public Contact(String email, String firstName, String lastName, String dateOfBirth, String mobileNo, String telePhone){
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email  = email;
		this.mobileNo = mobileNo;
		this.telePhoneNo = telePhone;
		this.dateOfBirth = dateOfBirth;
		
	}
		
	void validate() throws PhoneNumberMissingException, InvalidEmailException, MandatoryAttributeException {
		
		String emailPattern = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		
		if(this.firstName.equalsIgnoreCase("") || this.firstName == null){
			throw new MandatoryAttributeException();
		}
		
		else if(this.lastName.equalsIgnoreCase("") || this.lastName == null){
			throw new MandatoryAttributeException();
		}
		
		else if(this.dateOfBirth.equalsIgnoreCase("") || this.dateOfBirth == null){
			throw new MandatoryAttributeException();
		}
		
		else if(this.email.equalsIgnoreCase("") || this.email == null){
			throw new MandatoryAttributeException();
		}
		
		else if(!this.email.matches(emailPattern)) {
			throw new InvalidEmailException();
		}
		
		else if(this.mobileNo == null && this.telePhoneNo == null){
			throw new PhoneNumberMissingException();
		}
	}
	
	
	
	public static void main(String[] args) {	

		Contact contact = new Contact("palak.rathi.com","Palak","","09 May 1998","987654763","98765432");
		Stack stack = new Stack();
		
		Contact contact1 = new Contact("ssakshi.com","Sakshi","","12 April 1998","987654763","98765432");
		
		try {
			
			//2 Objects are inserted (pushed on stack)..
			stack.push(contact1);
			stack.push(contact);
			
			
			//3 Objects are popped from stack
			stack.pop();
			stack.pop();
			stack.pop();
			//stack.pop();
			
		}
		catch(Exception e) {
			System.out.println("Exception occurred..."+e.getMessage());
		}
		
		
		
		
		
		
		try {
			contact.validate();
		} 
		catch(InvalidEmailException e1) {
			InvalidEmailException email = new InvalidEmailException();
			System.out.println(email.getMessage());
		}
		catch (MandatoryAttributeException e) {
			MandatoryAttributeException exception = new MandatoryAttributeException();
			System.out.println(exception.getMessage());
		}
		
		catch(PhoneNumberMissingException e2) {
			PhoneNumberMissingException phone = new PhoneNumberMissingException();
			System.out.println(phone.getMessage());
		}	
		
		finally {
			System.out.println("Validated all the attributes...");
		}
	}
}
