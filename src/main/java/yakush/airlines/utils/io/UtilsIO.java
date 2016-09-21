package yakush.airlines.utils.io;

import java.io.*;
import java.util.ArrayList;

public class UtilsIO {

	public static ArrayList<String> readFile(File file) {

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

	public static File writeFile(String file_name, String values) {

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

		return file;

	}

	private static void closeConnection(Closeable closeable) {

		try {

			closeable.close();

		} catch (IOException e) {

			System.out.println(e.getMessage());

		}

	}



}
