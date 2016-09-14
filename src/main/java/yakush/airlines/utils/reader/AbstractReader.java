package yakush.airlines.utils.reader;

import yakush.airlines.exceptions.NoTxtFileException;
import yakush.airlines.exceptions.NoXMLFileException;

import java.util.ArrayList;

public abstract class AbstractReader {

	public static final String DIR_WITH_FILES = "files/";

	public abstract ArrayList<String> read(String fileName) throws NoTxtFileException, NoXMLFileException;

}
