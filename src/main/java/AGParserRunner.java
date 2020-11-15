import exception.AttributesNotFoundException;
import exception.DocumentNotFoundException;
import exception.ElementNotFoundException;
import exception.NoInputException;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import parser.HTMLParser;
import util.ParserUtils;

/**
 * AG Parser main executor.-
 */
public class AGParserRunner {

	public static final String DEFAULT_TARGET_COMPONENT_ID = "make-everything-ok-button";

	public static void main(String[] args) throws DocumentNotFoundException, NoInputException, ElementNotFoundException, AttributesNotFoundException {

		ParserUtils.validateInputDocuments(args);

		String originDocumentPath = args[0];
		String targetDocumentPath = args[1];
		String targetComponentId = DEFAULT_TARGET_COMPONENT_ID;

		if(args.length == 3){
			targetComponentId = args[2];
			System.out.println("ID provided, using new ID: " + targetDocumentPath);
		} else {
			System.out.println("No ID provided, using default ID: " + DEFAULT_TARGET_COMPONENT_ID);
		}



		Document originDocument = HTMLParser.generateDocumentFromLocalPath(originDocumentPath);
		Document targetDocument = HTMLParser.generateDocumentFromLocalPath(targetDocumentPath);

		Elements originElements = ParserUtils.retrieveElementById(originDocument, targetComponentId);

		Attributes originalAttributes = originElements.get(0).attributes();

		Element elementFound = ParserUtils.retrieveElementByMostMatchingAttributes(originalAttributes, targetDocument);

		System.out.println("Origin attributes:");
		System.out.println(originalAttributes.toString());

		System.out.println("Target attributes found: ");
		System.out.println(elementFound.toString());

		System.out.println("Target XPATH: ");
		System.out.println(ParserUtils.generateXPath(elementFound));
	}
}
