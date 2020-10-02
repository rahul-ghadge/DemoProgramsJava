package exceptionhandling;

public class PhoneNumberMissingException extends RuntimeException{

	public PhoneNumberMissingException() {
		super("Please enter your TelePhone / Mobile No.");
	}
	
}
