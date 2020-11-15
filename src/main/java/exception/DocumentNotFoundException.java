package exception;

import java.io.IOException;

public class DocumentNotFoundException extends IOException {

	public DocumentNotFoundException() {
		super();
	}

	public DocumentNotFoundException(String documentPath) {
		super("The document with path " +  documentPath + " was not found.");
	}
}
