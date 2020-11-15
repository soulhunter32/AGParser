package parser;

import exception.DocumentNotFoundException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.nio.file.Paths;

/**
 * HTML document parser.-
 */
public final class HTMLParser {

	public static final String DEFAULT_CHARSET = "UTF-8";

	/**
	 * Retrieves a {@link Document} object from a file, for the path parameter.-
	 *
	 * @param documentPath the path where the file is located
	 * @return a generated document object for the file path provided
	 * @exception DocumentNotFoundException if the document was not found in the provided path
	 */
	public static Document generateDocumentFromLocalPath(String documentPath) throws DocumentNotFoundException {
		try {
			return Jsoup.parse(new File(String.valueOf(Paths.get(documentPath))), DEFAULT_CHARSET);
		} catch (Exception e) {
			throw new DocumentNotFoundException(documentPath);
		}
	}
}
