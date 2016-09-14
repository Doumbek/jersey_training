package yakush.airlines.utils;

import yakush.airlines.parks.PassengerPlanesPark;
import yakush.airlines.utils.reader.AbstractReader;
import yakush.airlines.utils.reader.TxtFileReader;
import yakush.airlines.utils.reader.XmlFileReader;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.File;

public class Dialogs {

    public static void addPlanesFromFile(WebTarget target) {

        boolean isRepeat = true;

        while (isRepeat) {

            System.out.println("Choose file:");
            System.out.println("1 - txt");
            System.out.println("2 - xml");
            System.out.println("0 - cancel");

            int option = Console.chooseOption();
            File file;

            switch (option) {
                case 0:
                    isRepeat = false;
                    break;
                case 1:
                    file = new File(AbstractReader.DIR_WITH_FILES + "planes.txt");
                    target.path("add").request().post(Entity.entity(file, MediaType.TEXT_PLAIN_TYPE));
                    break;
                case 2:
                    file = new File(AbstractReader.DIR_WITH_FILES + "planes.xml");
                    target.path("add").request().post(Entity.entity(file, MediaType.TEXT_XML_TYPE));
                    break;
                default:
                    System.out.println("\nYou should choose option from available values from menu!");
                    break;
            }

        }

    }

    public static void getCommonCapacity (WebTarget target) {

        boolean isRepeat = true;

        while (isRepeat) {

            System.out.println("Calculate common capacity:");
            System.out.println("1 - load");
            System.out.println("2 - passengers");
            System.out.println("0 - cancel");

            int option = Console.chooseOption();

            switch (option) {
                case 0:
                    isRepeat = false;
                    break;
                case 1:
                    System.out.println("Common load capacity: " + target.path("common").path("load").request().get(Integer.class));
                    break;
                case 2:
                    System.out.println("Common passengers capacity: " + target.path("common").path("passangers").request().get(Integer.class));
                    break;
                default:
                    System.out.println("\nYou should choose option from available values from menu!");
                    break;
            }

        }

    }

    public static void sortPlanesBy (WebTarget target) {

        boolean isRepeat = true;

        while (isRepeat) {

            System.out.println("Sort planes by:");
            System.out.println("1 - model (A -> Z)");
            System.out.println("2 - model (Z -> A)");
            System.out.println("3 - range (min -> max)");
            System.out.println("4 - range (max -> min)");
            System.out.println("0 - cancel");

            int option = Console.chooseOption();

            switch (option) {
                case 0:
                    isRepeat = false;
                    break;
                case 1:
                    System.out.println(target.path("sort").path("model").request().get(String.class));
                    break;
                case 2:
                    System.out.println(target.path("sort").path("model").queryParam("desc", true).request().get(String.class));
                    break;
                case 3:
                    System.out.println(target.path("sort").path("range").request().get(String.class));
                    break;
                case 4:
                    System.out.println(target.path("sort").path("range").queryParam("desc", true).request().get(String.class));
                    break;
                default:
                    System.out.println("\nYou should choose option from available values from menu!");
                    break;
            }

        }

    }

    public static void searchPlanesBy (WebTarget target) {

        boolean isRepeat = true;

        while (isRepeat) {

            System.out.println("1 - enter search parameters");
            System.out.println("0 - cancel");

            int option = Console.chooseOption();

            switch (option) {
                case 0:
                    isRepeat = false;
                    break;
                case 1:
                    String model = Console.getStringFromConsole("Enter model name: ");
                    int range = Console.getIntFromConsole("Enter range value: ");
                    int maxLoadCapacity = Console.getIntFromConsole("Enter max load capacity value: ");
                    int maxPassCapacity = Console.getIntFromConsole("Enter max passengers capacity value: ");

                    System.out.println("Search result is:\n" +
                            target.path("search")
                                    .queryParam("model", model)
                                    .queryParam("range", range)
                                    .queryParam("load", maxLoadCapacity)
                                    .queryParam("passengers", maxPassCapacity)
                                    .request()
                                    .get(String.class));
                    break;
                default:
                    System.out.println("\nYou should choose option from available values from menu!");
                    break;
            }

        }
    }

}
