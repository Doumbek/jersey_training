package yakush.airlines.utils.reader;

import yakush.airlines.exceptions.NoTxtFileException;
import yakush.airlines.utils.io.UtilsIO;

import java.util.ArrayList;

public class TxtFileReader extends AbstractReader{

	@Override
	public ArrayList<String> read(String fileName) throws NoTxtFileException {

		if(!fileName.contains(".txt")) {

			throw new NoTxtFileException("\nFile is not .txt format!");

		}

		return UtilsIO.readFile(DIR_WITH_FILES + fileName);

	}

}
