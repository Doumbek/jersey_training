package yakush.airlines.parks;

import yakush.airlines.exceptions.NoTxtFileException;
import yakush.airlines.exceptions.NoXMLFileException;
import yakush.airlines.exceptions.PlaneWasNotFoundException;
import yakush.airlines.planes.PassengerPlanes;
import yakush.airlines.utils.comporator.sort.ByModelComporator;
import yakush.airlines.utils.io.UtilsIO;
import yakush.airlines.utils.jdbc.MySQLDBWorker;
import yakush.airlines.utils.reader.AbstractReader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class PassengerPlanesPark {

	private final ArrayList<PassengerPlanes> park = new ArrayList<PassengerPlanes>();
	private static final String OUTPUT_INFO_FILE = "info.txt";

	public PassengerPlanesPark () {
		this.addNewPlane(new PassengerPlanes("Model3", 20000, 6000, 50));
		this.addNewPlane(new PassengerPlanes("Model4", 50000, 2000, 30));
		this.addNewPlane(new PassengerPlanes("Model2", 30000, 4000, 40));
		this.addNewPlane(new PassengerPlanes("Model5", 30000, 4000, 40));
		this.addNewPlane(new PassengerPlanes("Model8", 30000, 7000, 40));
	}


	public void addNewPlane(PassengerPlanes plane) {
		this.park.add(plane);
	}

	public void addNewPlanesFromFile(String fileName, AbstractReader reader) {

		ArrayList<String> planes = null;

		try {

			planes = reader.read(fileName);

			for(String plane : planes) {

				String[] attributes = plane.split(":");

				String model = attributes[0];
				int range  = intValueHandler(attributes[1]);
				int maxLoadCapacity = intValueHandler(attributes[2]);
				int maxPassCapacity = intValueHandler(attributes[3]);

				this.park.add(new PassengerPlanes(model, range, maxLoadCapacity, maxPassCapacity));

			}

//			System.out.println("\nPlanes was added successful!");

		} catch (NoTxtFileException | NoXMLFileException e) {

			System.out.println(e.getMessage());

		}

	}

	private int intValueHandler(String string) {

		int value = 0;

		try {

			value  = Integer.valueOf(string);

		} catch(NumberFormatException ignored) {}

		return value;

	}

	public void writePlanesInfoToFile() {
		UtilsIO.writeFile(OUTPUT_INFO_FILE, this.toString());
	}

	public int getCommonPassCapacity() {

		int commonPassCapacity = 0;

		for (PassengerPlanes plane: this.park) {

			commonPassCapacity += plane.getMaxPassCapacity();

		}

		return commonPassCapacity;

	}

	public int getCommonLoadCapacity() {

		int commonLoadCapacity = 0;

		for (PassengerPlanes plane: this.park) {

			commonLoadCapacity += plane.getMaxLoadCapacity();

		}

		return commonLoadCapacity;

	}

	public Set<PassengerPlanes> findBy(String model, int range, int maxLoadCapacity, int maxPassCapacity) {

		Set<PassengerPlanes> searchResult = new TreeSet<PassengerPlanes>(new ByModelComporator());

		for(PassengerPlanes plane : this.park) {

			if (plane.getModel().equals(model)) {
				searchResult.add(plane);
				continue;
			}

			if (plane.getRange() == range) {
				searchResult.add(plane);
				continue;
			}

			if (plane.getMaxLoadCapacity() == maxLoadCapacity) {
				searchResult.add(plane);
				continue;
			}

			if (plane.getMaxPassCapacity() == maxPassCapacity) {
				searchResult.add(plane);
			}

		}

		return searchResult;

	}


//	public void showPlanesFromDB(){
//
//		ArrayList<PassengerPlanes> result = new ArrayList<PassengerPlanes>();
//		MySQLDBWorker dbWorker = new MySQLDBWorker();
//
//		Connection connection = dbWorker.getConnection();
//
//		try {
//
//			Statement statement = connection.createStatement();
//
//			ResultSet resultSet = statement.executeQuery("SELECT * FROM planes");
//
//			while(resultSet.next()) {
//
//				result.add(new PassengerPlanes(
//						resultSet.getString("model"),
//						resultSet.getInt("range"),
//						resultSet.getInt("max_load"),
//						resultSet.getInt("max_passengers")));
//			}
//
//			StringBuilder result_string = new StringBuilder();
//
//			for(PassengerPlanes plane: result) {
//				result_string.append("--------------------").append("\n");
//				result_string.append(plane.toString());
//
//			}
//
//			System.out.println(result_string);
//
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//
//		}
//
//		dbWorker.closeConnection();
//
//	}

	public ArrayList<PassengerPlanes> getPark() {
		return park;
	}

	@Override
	public String toString() {

		StringBuilder string = new StringBuilder();

		for(PassengerPlanes plane: this.park) {
			string.append("--------------------").append("\n");
			string.append(plane.toString());

		}

		return string.toString();

	}

}
