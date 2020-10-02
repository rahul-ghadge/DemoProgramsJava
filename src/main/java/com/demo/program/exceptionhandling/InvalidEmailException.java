package exceptionhandling;

public class InvalidEmailException extends RuntimeException {

	public InvalidEmailException() {
		super("Invalid Email ID ! ");
	}
	
}
