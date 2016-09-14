package yakush.airlines.utils.reader;

import yakush.airlines.exceptions.NoXMLFileException;
import yakush.airlines.utils.parser.PlanesSAXParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

public class XmlFileReader extends AbstractReader {

	@Override
	public ArrayList<String> read(String fileName) throws NoXMLFileException {

		if(!fileName.contains(".xml")) {

			throw new NoXMLFileException("\nFile is not .xml format!");

		}

		SAXParserFactory factory = SAXParserFactory.newInstance();
		PlanesSAXParser handler = new PlanesSAXParser();
		ArrayList<String> file_value = new ArrayList<String>();


		try {
			factory.newSAXParser().parse(DIR_WITH_FILES + fileName, handler);
			file_value = handler.getFileValue();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println("Parsing fails: " + e.getMessage());
		}

		return file_value;

	}

}
