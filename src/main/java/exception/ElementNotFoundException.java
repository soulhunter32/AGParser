package exception;

public class ElementNotFoundException extends Throwable {
	public ElementNotFoundException(String documentPath, String elementId) {
		super("The element " + elementId + " was not found on document " + documentPath);
	}
}
