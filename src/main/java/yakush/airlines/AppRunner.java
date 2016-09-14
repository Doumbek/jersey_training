package yakush.airlines;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import yakush.airlines.exceptions.PlaneWasNotFoundException;
import yakush.airlines.parks.PassengerPlanesPark;
import yakush.airlines.planes.PassengerPlanes;
import yakush.airlines.utils.Console;
import yakush.airlines.utils.Dialogs;
import yakush.airlines.utils.Search;
import yakush.airlines.utils.Sort;
import yakush.airlines.utils.reader.TxtFileReader;
import yakush.airlines.utils.reader.XmlFileReader;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.net.URI;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class AppRunner {

	public static final String BASE_URI = "http://localhost:8080/services/";

	private static HttpServer startServer() {
		final ResourceConfig rc = new ResourceConfig().packages("yakush.airlines.services");
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
	}

	public static void main(String[] args) {

		HttpServer server = startServer();
		WebTarget airlines_target = ClientBuilder.newClient().target(BASE_URI).path("airlines");

		boolean isRepeat = true;

		System.out.println("Hello to our airline!");

		while(isRepeat) {

			System.out.println("\nWhat do you want to do?");
			System.out.println("1 - show all planes");
			System.out.println("2 - get common capacity");
			System.out.println("3 - sort planes");
			System.out.println("4 - search planes");
			System.out.println("5 - add planes from file");
			System.out.println("6 - write information about planes to file");
//			System.out.println("7 - show planes from DB");
			System.out.println("0 - exit");

			int option = Console.chooseOption();

			switch(option) {

				case 0:
					isRepeat = false;
					System.out.println("Bye-bye!");
					server.stop();
					break;
				case 1:
					System.out.println(airlines_target.path("info").request().get(String.class));
					break;
				case 2:
					Dialogs.getCommonCapacity(airlines_target);
					break;
				case 3:
					Dialogs.sortPlanesBy(airlines_target);
					break;
				case 4:
					Dialogs.searchPlanesBy(airlines_target);
					break;
				case 5:
					Dialogs.addPlanesFromFile(airlines_target);
					break;
//				case 6:
//					passengerPlanesPark.writePlanesInfoToFile();
//					System.out.println("\nFile was successful created!");
//					break;
//				case 7:
//					passengerPlanesPark.showPlanesFromDB();
//					break;
				default:
					System.out.println("\nYou should choose option from available values from menu!");
					break;
			}

		}

	}


}

