package yakush.airlines.utils.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDBWorker {

	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/airline";
	private final String USERNAME = "root";
	private final String PASSWORD = "root";

	Connection connection = null;

	public MySQLDBWorker () {

		try {

			Class.forName(DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println("Mysql JDBC driver not found!");

		}

	}

	public Connection getConnection() {

		try {

			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (SQLException e) {

			System.err.println("No connection to BD");

		}

		return connection;

	}

	public void closeConnection() {

		try {

			if (connection != null && !connection.isClosed()) {

				connection.close();

			}

		} catch (SQLException e) {

			System.err.println("No active connection to BD");

		}


	}
}
