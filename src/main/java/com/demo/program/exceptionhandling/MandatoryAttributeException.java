package exceptionhandling;

public class MandatoryAttributeException extends RuntimeException {

	public MandatoryAttributeException() {

		super("Mandatory Field ! ");
			
	}
}
