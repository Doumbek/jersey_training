package yakush.airlines.utils.reader;

import yakush.airlines.exceptions.NoTxtFileException;
import yakush.airlines.utils.io.UtilsIO;

import java.io.File;
import java.util.ArrayList;

public class TxtFileReader extends AbstractReader{

	@Override
	public ArrayList<String> read(File file) throws NoTxtFileException {

//		if(!file.getName().contains(".txt")) {
//
//			throw new NoTxtFileException("\nFile is not .txt format!");
//
//		}

		return UtilsIO.readFile(file);

	}

}
