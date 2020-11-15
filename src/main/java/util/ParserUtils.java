package util;

import exception.AttributesNotFoundException;
import exception.DocumentNotFoundException;
import exception.ElementNotFoundException;
import exception.NoInputException;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Utility class for parsing.-
 */
public final class ParserUtils {


	public static final String ORIGIN_DOCUMENT = "origin";
	public static final String TARGET_DOCUMENT = "target";

	/**
	 * Validates the documents entered are entered.-
	 *
	 * @param inputs origin and target document paths
	 * @throws NoInputException if a document has not been entered
	 */
	public static void validateInputDocuments(String[] inputs) throws NoInputException {

		if(inputs.length == 0 || Objects.isNull(inputs[0]) || inputs[0].equals("")){
			throw new NoInputException(ORIGIN_DOCUMENT);
		}

		if(inputs.length == 1 || Objects.isNull(inputs[1])  || inputs[1].equals("")){
			throw new NoInputException(TARGET_DOCUMENT);
		}
	}

	/**
	 * Retrieves an element by and id from a document.-
	 *
	 * @param document the document to retrieve the element from
	 * @param targetElementId the element id to retrieve
	 * @throws DocumentNotFoundException if the document is invalid
	 * @throws ElementNotFoundException if the element was not found
	 * @return a {@link Elements} object for the fond id
	 */
	public static Elements retrieveElementById(Document document, String targetElementId) throws DocumentNotFoundException, ElementNotFoundException {

		Elements elements = null;

		if(Objects.isNull(document)){
			throw new DocumentNotFoundException();
		}
		if (!Objects.isNull(targetElementId) && !targetElementId.equals("")) {
			elements = document.select("#" + targetElementId);
		}

		if (elements.isEmpty()) {
			throw new ElementNotFoundException(document.baseUri(), targetElementId);
		}
		return elements;
	}

	/**
	 * Retrieves the element with most attribute matches for the current original attributes.-
	 * @param originalAttributes the attributes to match
	 * @param document the target document to evaluate matches
	 * @return a {@link Element} with the higher amount of matches
	 * @throws DocumentNotFoundException if document is not found
	 * @throws AttributesNotFoundException if there are no attributes to look for matches
	 */
	public static Element retrieveElementByMostMatchingAttributes(Attributes originalAttributes, Document document) throws DocumentNotFoundException, AttributesNotFoundException {

		Element matchingElement = null;

		if(Objects.isNull(document)){
			throw new DocumentNotFoundException();
		}
		if (!Objects.isNull(originalAttributes) && originalAttributes.isEmpty()) {
			throw new AttributesNotFoundException();
		}

		//Collects all a buttons containing text
		List<Element> buttonList = document.getElementsByTag("a").stream().filter(element -> element.hasClass("btn")).collect(Collectors.toList());

		int maxMatches = 0;

		for(Element b : buttonList) {
			int currentMatches = 0;
			for (Attribute attr: originalAttributes) {
				if(!b.getElementsByAttributeValue(attr.getKey(), attr.getValue()).isEmpty()){
					currentMatches++;
					if (currentMatches > maxMatches) {
						matchingElement = b;
						maxMatches = currentMatches;
					}
				}
			}
		};

		return matchingElement;
	}

	/**
	 * Generates an XPATH for the element passed as parameters. If traverses the nodes upwards till the document root.-
	 *
	 * @param element the element to generate the XPATH for
	 * @return a string with the XPATH for the current element
	 */
	public static String generateXPath(Element element) {

		List<String> parentList = new ArrayList<>();

		for (int i = 0; i < element.parents().size(); i++){
			parentList.add(element.parents().get(i).tagName() +
					(element.parents().get(i).classNames().isEmpty() ? "" :
							element.parents().get(i).classNames()));
		}

		Collections.reverse(parentList);

		return String.join(" > ", parentList).toString();
	}
}
