package yakush.airlines.utils.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class PlanesSAXParser extends DefaultHandler {

	private ArrayList<String> fileValue = new ArrayList<String>();
	private StringBuilder planeInString;
	private StringBuilder elementValue;

	@Override
	public void startDocument() throws SAXException {
//		System.out.println("Start parse XML document with planes....");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		elementValue = new StringBuilder();

		if(qName.equals("plane")) {
			planeInString = new StringBuilder();
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(qName.equals("plane")) {

			fileValue.add(planeInString.toString());

		} else {

			if(qName.equals("model")) {
				planeInString.append(elementValue).append(":");
			} else if (qName.equals("range")) {
				planeInString.append(elementValue).append(":");
			} else if(qName.equals("max_load")) {
				planeInString.append(elementValue).append(":");
			} else if(qName.equals("max_passengers")) {
				planeInString.append(elementValue);
			}

		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		elementValue.append(ch, start, length);
	}

	@Override
	public void endDocument() throws SAXException {
//		System.out.println("Parsing was finished successful!");
	}

	public ArrayList<String> getFileValue() {
		return fileValue;
	}

}
