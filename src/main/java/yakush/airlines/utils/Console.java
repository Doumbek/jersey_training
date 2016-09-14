package yakush.airlines.utils;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console {

    public static int chooseOption() {

        int option;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose options from menu: ");

        try {
            option = scanner.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Enter integer number!");
            option = chooseOption();
        } catch (NoSuchElementException ignored) {
            option = 0;
        }

        return option;

    }

    public static String getStringFromConsole(String message) {

        Scanner scanner = new Scanner(System.in);
        String result = "";

        System.out.print(message);

        if (scanner.hasNextLine()) {

            result = scanner.nextLine();

        } else {

            result = getStringFromConsole(message);

        }

        return result;

    }

    public static int getIntFromConsole(String message) {

        int result = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print(message);
        String temp = scanner.nextLine();

        if (!temp.isEmpty()) {

            try {

                result = Integer.valueOf(temp);

            } catch (NumberFormatException e) {

                getIntFromConsole(message);

            }

        }

        return result;

    }


}
