package yakush.airlines.utils.io;

import java.io.*;
import java.util.ArrayList;

public class UtilsIO {

//	public static final String DIR_WITH_FILES = "files/";

	public static ArrayList<String> readFile(String file_name) {

		File file = new File(file_name);

		ArrayList<String> file_values = new ArrayList<String>();

		BufferedReader reader = null;

		try {

			reader = new BufferedReader(new FileReader(file));

			String line;

			while ((line = reader.readLine()) != null) {

				file_values.add(line);

			}

		} catch (FileNotFoundException e) {

			System.out.println(e.getMessage());

		} catch (IOException e) {

			System.out.println(e.getMessage());

		} finally {

			if (reader != null) {

				closeConnection(reader);

			}

		}

		return file_values;

	}

	public static void writeFile(String file_name, String values) {

		File file = new File(file_name);
		PrintWriter writer = null;

		try {

			writer = new PrintWriter(new FileWriter(file));

			writer.write(values);

		} catch (FileNotFoundException e) {

			System.out.println(e.getMessage());

		} catch (IOException e) {

			System.out.println(e.getMessage());

		} finally {

			if (writer != null) {

				closeConnection(writer);

			}

		}

	}

	private static void closeConnection(Closeable closeable) {

		try {

			closeable.close();

		} catch (IOException e) {

			System.out.println(e.getMessage());

		}

	}



}
