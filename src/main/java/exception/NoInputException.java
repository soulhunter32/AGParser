package exception;

public class NoInputException extends Throwable {
	public NoInputException() {
	}

	public NoInputException(String message) {
		super("The " +  message + " document was no entered.");
	}
}
